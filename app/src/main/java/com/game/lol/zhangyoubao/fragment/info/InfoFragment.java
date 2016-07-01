package com.game.lol.zhangyoubao.fragment.info;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.adapter.info.InfoPagerFragmentAdapter;
import com.game.lol.zhangyoubao.constant.Key;
import com.game.lol.zhangyoubao.constant.Type;
import com.game.lol.zhangyoubao.model.InfoADBean;
import com.game.lol.zhangyoubao.model.InfoTitleBean;
import com.game.lol.zhangyoubao.util.RetrofitUtil;
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
 * 创建日期：2016/6/24 21:44
 * 创建描述：资讯界面的Fragment
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class InfoFragment extends Fragment {
    private static final String TAG = "InfoFragment";
    @BindView(R.id.iv_loading)
    ImageView ivLoading;
    @BindView(R.id.tablayout_info)
    TabLayout tablayoutInfo;
    @BindView(R.id.vp_fragment)
    ViewPager vpFragment;
    @BindView(R.id.rlayout_loading)
    RelativeLayout rlayoutLoading;
    @BindView(R.id.tv_loading_failed)
    TextView tvLoadingFailed;

    private FragmentManager fm;
    private Context context;
    private RetrofitUtil<InfoTitleBean> titleBeanRetrofitUtil;
    private RetrofitUtil<InfoADBean> adBeanRetrofitUtil;
    private List<InfoTitleBean.DataBean> titleList;
    private List<Fragment> listF;
    private InfoPagerFragmentAdapter adapter;
    private Animation animation;
    private String adJsonString;

    public InfoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        fm = getChildFragmentManager();
        titleBeanRetrofitUtil = new RetrofitUtil<>(context);
        adBeanRetrofitUtil = new RetrofitUtil<>(context);
        animation = AnimationUtils.loadAnimation(context, R.anim.anim_rotate_loading);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ivLoading.setAnimation(animation);
        vpFragment.setOffscreenPageLimit(4); //设置ViewPager缓存4页
        initTab();  //OK
        initTabTitleData(); //OK
        setListener();
    }

    private void setListener() {
        //点击重新加载
        tvLoadingFailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initTabTitleData();
            }
        });
    }

    /**
     * 初始化TabLayout
     */
    private void initTab() {
        for (int i = 0; i < 4; i++) {
            tablayoutInfo.addTab(tablayoutInfo.newTab().setTag(i));
        }
    }

    private void initFragment() {
        listF = new ArrayList<>();
        Bundle bundle;
        for (int i = 0; i < titleList.size(); i++) {
            InfoPagerFragment fragment = new InfoPagerFragment();
            bundle = new Bundle();
            bundle.putString("id", titleList.get(i).getId());
            bundle.putString("adJsonString", adJsonString);
            fragment.setArguments(bundle);
            listF.add(fragment);
        }
    }

    /**
     * AD广告数据
     */
    private void initADsData() {
        Logger.i("AD加载数据============");
        //http://lol.zhangyoubao.com/apis/rest/ItemsService/ads?i_=0&t_=1466491741828&p_=7829
        adBeanRetrofitUtil.getLOLStringDataFromNet(Type.ITEMS_SERVICE, Type.ads, null, new RetrofitUtil.CallBack<String>() {
            @Override
            public void onLoadingDataComplete(String body) {
                adJsonString = body;
                Logger.i("ADs数据加载完毕：" + body);
                //获取完标题数据和AD数据，再根据标题去初始化Fragment
                initFragment();
                setAdapter();
                rlayoutLoading.setVisibility(View.VISIBLE);
                ivLoading.clearAnimation();
                ivLoading.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingDataFailed(Throwable t) {
                ivLoading.clearAnimation();
                ivLoading.setVisibility(View.GONE);
                tvLoadingFailed.setVisibility(View.VISIBLE);
                Toast.makeText(context, "AD广告数据获取失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Tab标题数据
     */
    private void initTabTitleData() {
        Logger.i("资讯加载数据============");
        ivLoading.setVisibility(View.VISIBLE);
        animation.start();
        tvLoadingFailed.setVisibility(View.GONE);
        Map<String, String> map = new HashMap<>();
        map.put(Key.cattype, "news");
        titleBeanRetrofitUtil.getLOLBeanDataFromNet(Type.CATALOGS_SERVICE, Type.all, map, InfoTitleBean.class, new RetrofitUtil.CallBack<InfoTitleBean>() {
            @Override
            public void onLoadingDataComplete(InfoTitleBean body) {
                //加载完标题数据，接着加载ADs数据
                initADsData();
                Logger.i("资讯数据加载完毕=========" + body.getData().size());
//                animation.cancel();
//                ivLoading.setVisibility(View.GONE);
                titleList = body.getData();

            }

            @Override
            public void onLoadingDataFailed(Throwable t) {
                animation.cancel();
                ivLoading.setVisibility(View.GONE);
                tvLoadingFailed.setVisibility(View.VISIBLE);
//                Toast.makeText(context, "标题数据获取失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter() {
        adapter = new InfoPagerFragmentAdapter(fm, listF);
        vpFragment.setAdapter(adapter);
        tablayoutInfo.setupWithViewPager(vpFragment);
//        //绑定后要重新设置文字，不然会不显示文字
        for (int i = 0; i < titleList.size(); i++) {
            tablayoutInfo.getTabAt(i).setText(titleList.get(i).getName());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
