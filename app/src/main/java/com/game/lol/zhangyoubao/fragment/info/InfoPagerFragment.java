package com.game.lol.zhangyoubao.fragment.info;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.adapter.info.InfoADsAdapter;
import com.game.lol.zhangyoubao.adapter.info.InfoRecyclerViewAdapter;
import com.game.lol.zhangyoubao.constant.Key;
import com.game.lol.zhangyoubao.constant.Type;
import com.game.lol.zhangyoubao.model.InfoADBean;
import com.game.lol.zhangyoubao.model.InfoListBean;
import com.game.lol.zhangyoubao.util.PixelUtil;
import com.game.lol.zhangyoubao.util.RetrofitUtil;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/25 17:14
 * 创建描述：资讯界面TabLayout下的ViewPager里面的Fragment
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class InfoPagerFragment extends Fragment {
    private static final String TAG = "InfoPagerFragment";

    @BindView(R.id.vp_AD)
    ViewPager vpAD;
    @BindView(R.id.rv_info)
    RecyclerView rvInfo;
    @BindView(R.id.ptrf)
    PullToRefreshScrollView ptrf;
    @BindView(R.id.ad_dot)
    LinearLayout adDot;

    private String catid;  //请求地址的 id
    private Context context;
    private RetrofitUtil<InfoListBean> listBeanRetrofitUtil;
    private List<InfoADBean.DataBean> infoAdBeanList;
    private List<InfoListBean.DataBean> infoListBeanList;
    private boolean isRefresh = false;
    private int page = 1;
    private InfoRecyclerViewAdapter adapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //设置延迟3秒后，自动切换到下一个viewPage广告页
            vpAD.setCurrentItem(vpAD.getCurrentItem() + 1);

            //每改变一次，就延迟4秒之后，自动切换下一张图片
            handler.sendEmptyMessageDelayed(0, 4000);   // 发送延迟消息机制
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        infoListBeanList = new ArrayList<>();
        listBeanRetrofitUtil = new RetrofitUtil<>(context);
        Bundle bundle = getArguments();
        catid = bundle.getString("id");
        String adJsonString = bundle.getString("adJsonString");
//        Logger.i("id:" + catid + " adJsonString:" + adJsonString);
        Gson gson = new Gson();
        if (!TextUtils.isEmpty(adJsonString)) {
            InfoADBean infoADBean = gson.fromJson(adJsonString, InfoADBean.class);
            infoAdBeanList = infoADBean.getData();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_pager_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rvInfo.setLayoutManager(new LinearLayoutManager(context));
        rvInfo.setFocusable(false);
        setADsViewPagerAdapter();
//        Logger.i("id:" + catid + " infoAdBeanList:" + infoAdBeanList.toString());
        initData(page);//默认加载数据第一页
        setAdapter();
        setListener();
    }

    private void setADsViewPagerAdapter() {
        vpAD.setOffscreenPageLimit(5);
        InfoADsAdapter adapter = new InfoADsAdapter(context, infoAdBeanList);
        vpAD.setAdapter(adapter);
        int centerValue = Integer.MAX_VALUE / 2;

        int value = centerValue % infoAdBeanList.size();
        vpAD.setCurrentItem(centerValue - value);
        initDots();
        //首次加载，显示第一个圆点
        updateDot();
        //每改变一次，就延迟4秒之后，自动切换下一张图片
        handler.sendEmptyMessageDelayed(0, 4000);   // 延迟4秒之后操作
    }

    /**
     * 初始化圆点
     */
    private void initDots() {
        int dotWidth = PixelUtil.dp2px(context, 8);
        int marginWidth = PixelUtil.dp2px(context, 8);
        for (int i = 0; i < infoAdBeanList.size(); i++) {
            View view = new View(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dotWidth, dotWidth); //参数指定宽高都是10
            if (i != 0) {
                params.leftMargin = marginWidth;
            }
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.ad_dot_selector);
            adDot.addView(view);
        }
    }

    private void setListener() {
        //上下拉刷新的监听
        ptrf.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                infoListBeanList.clear();
                page = 1;
                initData(page);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                initData(++page);
            }
        });
        //AD广告轮播的监听
        vpAD.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updateDot();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 更新AD里的小圆点
     */
    private void updateDot() {
        int currentItem = vpAD.getCurrentItem() % infoAdBeanList.size();
        for (int i = 0; i < adDot.getChildCount(); i++) {
            adDot.getChildAt(i).setEnabled(i == currentItem);
        }
    }

    private void setAdapter() {
        adapter = new InfoRecyclerViewAdapter(context);
        rvInfo.setAdapter(adapter);
        //RecyclerView条目的点击事件
        adapter.setOnItemClickListener(new InfoRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int position) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "点击了条目：" + position, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void initData(int pages) {
        Map<String, String> params = new HashMap<>();
        params.put(Key.catid, catid);
        params.put(Key.cattype, "news");
        params.put(Key.page, String.valueOf(pages));
        listBeanRetrofitUtil.getLOLBeanDataFromNet(Type.ITEMS_SERVICE, Type.lists, params, InfoListBean.class, new RetrofitUtil.CallBack<InfoListBean>() {
            @Override
            public void onLoadingDataComplete(InfoListBean body) {
//                setAdapter();
                List<InfoListBean.DataBean> ListBeanList = body.getData();
                infoListBeanList.addAll(ListBeanList);
                adapter.updateListBeanList(infoListBeanList);
                ptrf.onRefreshComplete();
            }

            @Override
            public void onLoadingDataFailed(Throwable t) {
                Toast.makeText(context, "RecyclerView 条目数据加载失败", Toast.LENGTH_SHORT).show();
                page--;
                ptrf.onRefreshComplete();
            }
        });
    }

}
