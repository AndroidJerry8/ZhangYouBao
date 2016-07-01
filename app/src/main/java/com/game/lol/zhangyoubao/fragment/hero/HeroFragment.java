package com.game.lol.zhangyoubao.fragment.hero;

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

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.adapter.hero.HeroPagerFragmentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/22 10:15
 * 创建描述：英雄界面的Fragment
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class HeroFragment extends Fragment {


    @BindView(R.id.tablayout_hero)
    TabLayout tablayoutHero;
    @BindView(R.id.vp_fragment)
    ViewPager vpFragment;
    private FragmentManager fm;
    private Context context;
    String[] tabTitle = new String[]{"周免/折扣", "我的英雄", "全部英雄"};
    Fragment[] listF;
    private HeroPagerFragmentAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        fm = getChildFragmentManager();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        vpFragment.setOffscreenPageLimit(3);
        initTab();
        initFragment();
        setAdapter();
    }


    private void setAdapter() {
        adapter = new HeroPagerFragmentAdapter(fm, listF);
        vpFragment.setAdapter(adapter);
        tablayoutHero.setupWithViewPager(vpFragment);
        tablayoutHero.getTabAt(0).setText("周免/折扣");
        tablayoutHero.getTabAt(1).setText("我的英雄");
        tablayoutHero.getTabAt(2).setText("全部英雄");

    }

    private void initFragment() {
        HeroPagerFragment1 fragment1 = new HeroPagerFragment1();
        HeroPagerFragment2 fragment2 = new HeroPagerFragment2();
        HeroPagerFragment3 fragment3 = new HeroPagerFragment3();
        listF = new Fragment[]{fragment1, fragment2, fragment3};
    }

    private void initTab() {
        tablayoutHero.addTab(tablayoutHero.newTab());
        tablayoutHero.addTab(tablayoutHero.newTab());
        tablayoutHero.addTab(tablayoutHero.newTab());
    }

}
