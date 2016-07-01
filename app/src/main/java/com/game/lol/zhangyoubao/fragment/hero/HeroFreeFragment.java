package com.game.lol.zhangyoubao.fragment.hero;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.adapter.hero.HeroFreeRCVAdapter;
import com.game.lol.zhangyoubao.adapter.hero.HeroNextFreeRCVAdapter;
import com.game.lol.zhangyoubao.constant.Type;
import com.game.lol.zhangyoubao.model.HeroFreeBean;
import com.game.lol.zhangyoubao.util.RetrofitUtil;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/30 10:11
 * 创建描述：英雄界面里，周免折扣Tab下的周免Fragment
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class HeroFreeFragment extends Fragment {
    private static final String TAG = "HeroFreeFragment";
    @BindView(R.id.tv_free_time)
    TextView tvFreeTime;
    @BindView(R.id.rv_free_hero)
    RecyclerView rvFreeHero;
    @BindView(R.id.content_free)
    RelativeLayout contentFree;
    @BindView(R.id.tv_next_free_time)
    TextView tvNextFreeTime;
    @BindView(R.id.rv_next_free_hero)
    RecyclerView rvNextFreeHero;
    @BindView(R.id.content_next_free)
    RelativeLayout contentNextFree;
    @BindView(R.id.iv_loading)
    ImageView ivLoading;
    @BindView(R.id.tv_loading_failed)
    TextView tvLoadingFailed;
    @BindView(R.id.tv_free)
    TextView tvFree;
    @BindView(R.id.tv_next_free)
    TextView tvNextFree;
    @BindView(R.id.ptrf_free)
    PullToRefreshScrollView ptrfFree;
    private Context context;
    private Animation animation;
    private RetrofitUtil<HeroFreeBean> retrofitUtil;
    private Observable<HeroFreeBean> observable;
    private Subscriber<HeroFreeBean> subscriber;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        retrofitUtil = new RetrofitUtil<>(context);
        animation = AnimationUtils.loadAnimation(context, R.anim.anim_rotate_loading);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hero_free_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ivLoading.setAnimation(animation);
        ptrfFree.setMode(PullToRefreshBase.Mode.DISABLED);
        rvFreeHero.setLayoutManager(new GridLayoutManager(context, 4)); //本周周免的RecyclerView
        rvNextFreeHero.setLayoutManager(new GridLayoutManager(context, 4)); //下周周免的RecyclerView
        initData();
        initListener();
    }

    private void initListener() {
        tvLoadingFailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivLoading.setAnimation(animation);
                initData();
//                observable.replay();
//                observable.retry();
            }
        });
    }

    private void initData() {
        ivLoading.setVisibility(View.VISIBLE);
        tvLoadingFailed.setVisibility(View.GONE);
        observable = Observable.create(new Observable.OnSubscribe<HeroFreeBean>() {
            @Override
            public void call(final Subscriber<? super HeroFreeBean> subscriber) {
                retrofitUtil.getLOLBeanDataFromNet(Type.ROLES_SERVICE, Type.freeV1, null, HeroFreeBean.class, new RetrofitUtil.CallBack<HeroFreeBean>() {
                    @Override
                    public void onLoadingDataComplete(HeroFreeBean body) {
                        subscriber.onNext(body);
                        subscriber.onCompleted();
                    }

                    @Override
                    public void onLoadingDataFailed(Throwable t) {
                        subscriber.onError(t);
                        Toast.makeText(context, "周免英雄数据获取失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        subscriber = new Subscriber<HeroFreeBean>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted : 加载完了");
                ivLoading.clearAnimation();
                ivLoading.setVisibility(View.GONE);
                contentFree.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(Throwable e) {
                ivLoading.clearAnimation();
                ivLoading.setVisibility(View.GONE);
                tvLoadingFailed.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNext(HeroFreeBean heroFreeBean) {
                HeroFreeBean.DataBean data = heroFreeBean.getData();
                String currenttitle = data.getCurrenttitle();
                String currentdate = data.getCurrentdate();
                tvFree.setText(currenttitle);
                tvFreeTime.setText(currentdate);
                List<HeroFreeBean.DataBean.CurrentperiodBean> currentperiod = data.getCurrentperiod();
                setFreeAdapter(currentperiod);
                if (!TextUtils.isEmpty(data.getNexttitle())) {
                    contentNextFree.setVisibility(View.VISIBLE);
                    tvNextFree.setText(data.getNexttitle());
                    tvNextFreeTime.setText(data.getNextdate());
                    List<HeroFreeBean.DataBean.NextperiodBean> nextperiod = data.getNextperiod();
                    setNextFreeAdapter(nextperiod);
                }
            }
        };
        //绑定见监听者
        observable.subscribe(subscriber);
    }

    /**
     * 下周周免的Adapter
     *
     * @param nextperiod
     */
    private void setNextFreeAdapter(List<HeroFreeBean.DataBean.NextperiodBean> nextperiod) {
        HeroNextFreeRCVAdapter nextAdapter = new HeroNextFreeRCVAdapter(context, nextperiod);
        rvNextFreeHero.setAdapter(nextAdapter);
        nextAdapter.setOnItemClickListener(new HeroNextFreeRCVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int itemId) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "点击条目ID：" + itemId, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    /**
     * 本周周免的Adapter
     *
     * @param currentperiod
     */
    private void setFreeAdapter(List<HeroFreeBean.DataBean.CurrentperiodBean> currentperiod) {
        HeroFreeRCVAdapter adapter = new HeroFreeRCVAdapter(context, currentperiod);
        rvFreeHero.setAdapter(adapter);
        adapter.setOnItemClickListener(new HeroFreeRCVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int itemId) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "点击条目ID：" + itemId, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


}
