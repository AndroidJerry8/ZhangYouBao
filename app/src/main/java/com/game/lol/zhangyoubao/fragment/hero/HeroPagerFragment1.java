package com.game.lol.zhangyoubao.fragment.hero;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.adapter.hero.HeroFreeRCVAdapter;
import com.game.lol.zhangyoubao.constant.Type;
import com.game.lol.zhangyoubao.model.HeroFreeBean;
import com.game.lol.zhangyoubao.util.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/28 19:28
 * 创建描述：英雄界面里周免、折扣Fragment
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class HeroPagerFragment1 extends Fragment implements View.OnClickListener {
    private static final String TAG = "HeroPagerFragment1";
    @BindView(R.id.btn_free)
    Button btnFree;
    @BindView(R.id.btn_discount)
    Button btnDiscount;
    @BindView(R.id.btn_background)
    LinearLayout btnBackground;
    @BindView(R.id.free_fragment_content)
    FrameLayout freeFragmentContent;
    private Context context;
    private FragmentManager fm;
    private RetrofitUtil<HeroFreeBean> retrofitUtil;
    private Observable<HeroFreeBean.DataBean> observable;
    private Subscriber<HeroFreeBean.DataBean> subscriber;

    private Fragment[] listF;
    private int index = 0;  //点击的ButtonTab标记
    private int currIndex = 0;  //当前的ButtonTab标记

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        fm = getChildFragmentManager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hero_pager_fragment1, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initFragment();
//        initWebViewData();
        setListener();
    }

    private void initFragment() {
        HeroFreeFragment heroFreeFragment = new HeroFreeFragment();
        HeroDiscountFragment heroDiscountFragment = new HeroDiscountFragment();
        listF = new Fragment[]{heroFreeFragment, heroDiscountFragment};
        fm.beginTransaction().add(R.id.free_fragment_content, heroFreeFragment)
                .show(heroFreeFragment)
                .commit();
    }

    private void setListener() {
        btnFree.setOnClickListener(this);
        btnDiscount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_free:
                btnBackground.setEnabled(true);
                btnDiscount.setTextColor(Color.BLACK);
                btnFree.setTextColor(Color.WHITE);
                fm.beginTransaction().hide(listF[1]).show(listF[0]).commit();

                break;
            case R.id.btn_discount:
                btnBackground.setEnabled(false);
                btnFree.setTextColor(Color.BLACK);
                btnDiscount.setTextColor(Color.WHITE);
                if (!listF[1].isAdded()) {
                    fm.beginTransaction().add(R.id.free_fragment_content, listF[1]).hide(listF[0]).show(listF[1]).commit();
                } else {
                    fm.beginTransaction().hide(listF[0]).show(listF[1]).commit();
                }
                break;
        }
    }

}
