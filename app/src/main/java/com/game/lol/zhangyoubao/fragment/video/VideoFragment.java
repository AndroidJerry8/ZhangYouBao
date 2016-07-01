package com.game.lol.zhangyoubao.fragment.video;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
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
import com.game.lol.zhangyoubao.adapter.video.VideoFragmentAdapter;
import com.game.lol.zhangyoubao.constant.Key;
import com.game.lol.zhangyoubao.constant.Type;
import com.game.lol.zhangyoubao.model.VideoListBean;
import com.game.lol.zhangyoubao.util.RetrofitUtil;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
 * 创建日期：2016/6/21 21:49
 * 创建描述：视频界面的Fragment
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class VideoFragment extends Fragment {
    private static final String TAG = "VideoFragment";
    @BindView(R.id.tv_loading_failed)
    TextView tvLoadingFailed;
    @BindView(R.id.tablayout_video)
    TabLayout tablayoutVideo;
    @BindView(R.id.vp_fragment)
    ViewPager vpFragment;
    @BindView(R.id.rlayout_loading)
    RelativeLayout rlayoutLoading;
    @BindView(R.id.iv_loading)
    ImageView ivLoading;
    private List<Fragment> listF;
    private FragmentManager fm;
    private RetrofitUtil<VideoListBean> retrofitUtil;
    private VideoListBean.DataBean yuleBean;    //娱乐界面里的数据
    private VideoListBean.DataBean jieshuoBean; //解说界面里的数据
    private VideoListBean.DataBean saishiBean;  //赛事界面里的数据
    private Bundle bundle;
    private VideoFragmentAdapter adapter;
    private Context context;
    private Animation animation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        fm = getChildFragmentManager();
        retrofitUtil = new RetrofitUtil<>(context);
        animation = AnimationUtils.loadAnimation(context, R.anim.anim_rotate_loading);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ivLoading.setAnimation(animation);
        vpFragment.setOffscreenPageLimit(3); //设置ViewPager缓存3页
        initTab();
        initData();
        setListener();
    }

    /**
     * 从本地读数据
     */
    private boolean readDataFromLocal() {
        File cacheDir = context.getCacheDir();
        File file = new File(cacheDir, VideoListBean.class.getSimpleName() + ".txt");
        Log.i(TAG, "readDataFromLocal : " + file.getName());
        if (!file.exists()) {   //判断是否有文件
//            tvLoadingFailed.setVisibility(View.VISIBLE);
            return false;
        } else {
            try {
                FileInputStream inputStream = new FileInputStream(file);
                int available = inputStream.available();
                byte[] buffer = new byte[available];
                inputStream.read(buffer);
                String jsonStr = new String(buffer, "utf-8");
                Gson gson = new Gson();
                VideoListBean videoListBean = gson.fromJson(jsonStr, VideoListBean.class);
                List<VideoListBean.DataBean> dataList = videoListBean.getData();
                yuleBean = dataList.get(0);
                jieshuoBean = dataList.get(1);
                saishiBean = dataList.get(2);
                initFragment();
                setAdapter();
                Logger.i("视频 本地 数据加载完毕=========");
                rlayoutLoading.setVisibility(View.VISIBLE);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * RelativeLayout 的监听事件，主要处理加载数据失败时，重新加载数据
     */
    private void setListener() {
        //点击重新加载
        tvLoadingFailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
            }
        });
    }

    /**
     * 初始化娱乐、解说、赛事三个界面的Fragment
     */
    private void initFragment() {
        listF = new ArrayList<>();
        VideoPagerFragment yuleF = new VideoPagerFragment();
        bundle = new Bundle();
        bundle.putParcelable("data", yuleBean);
        yuleF.setArguments(bundle);
        listF.add(yuleF);

        VideoPagerFragment jieshuoF = new VideoPagerFragment();
        bundle = new Bundle();
        bundle.putParcelable("data", jieshuoBean);
        jieshuoF.setArguments(bundle);
        listF.add(jieshuoF);

        VideoPagerFragment saishiF = new VideoPagerFragment();
        bundle = new Bundle();
        bundle.putParcelable("data", saishiBean);
        saishiF.setArguments(bundle);
        listF.add(saishiF);

    }

    /**
     * 初始化 娱乐、解说、赛事TabLayout
     */
    private void initTab() {
        for (int i = 0; i < 3; i++) {
            tablayoutVideo.addTab(tablayoutVideo.newTab().setTag(i));
        }
    }

    private void setAdapter() {
        adapter = new VideoFragmentAdapter(fm, listF);
        vpFragment.setAdapter(adapter);
        //将ViewPager与TabLayout绑定
        tablayoutVideo.setupWithViewPager(vpFragment);
        //绑定后要重新设置文字，不然会不显示文字
        tablayoutVideo.getTabAt(0).setText(yuleBean.getName());
        tablayoutVideo.getTabAt(1).setText(jieshuoBean.getName());
        tablayoutVideo.getTabAt(2).setText(saishiBean.getName());
    }

    /**
     * 获取网络数据
     */
    private void initData() {
        final boolean isReaeFromLoacl = readDataFromLocal();
        Logger.i("视频 网络 加载数据============");
        if (!isReaeFromLoacl) {
            ivLoading.setVisibility(View.VISIBLE);
            animation.start();
        }
        tvLoadingFailed.setVisibility(View.GONE);
        Map<String, String> map = new HashMap<>();
        map.put(Key.cattype, "video");
        retrofitUtil.getLOLBeanDataFromNet(Type.CATALOGS_SERVICE, Type.all, map, VideoListBean.class, new RetrofitUtil.CallBack<VideoListBean>() {
            @Override
            public void onLoadingDataComplete(VideoListBean body) {
                Logger.i("视频 网络 数据加载完毕=========");
                List<VideoListBean.DataBean> dataList = body.getData();
                //在执行以下两个方法之前，必须获取到数据，不然会出现空指针异常
                yuleBean = dataList.get(0);
                jieshuoBean = dataList.get(1);
                saishiBean = dataList.get(2);
                initFragment();
                setAdapter();
                if (!isReaeFromLoacl) {
                    ivLoading.clearAnimation();
                    ivLoading.setVisibility(View.GONE);
                }
                rlayoutLoading.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingDataFailed(Throwable t) {
                ivLoading.clearAnimation();
                ivLoading.setVisibility(View.GONE);
                if (!isReaeFromLoacl) {
                    tvLoadingFailed.setVisibility(View.VISIBLE);
                }
                Toast.makeText(getActivity(), "视频页面数据加载失败", Toast.LENGTH_SHORT).show();
            }
        });
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
