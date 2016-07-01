package com.game.lol.zhangyoubao.adapter.hero;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/28 19:59
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class HeroPagerFragmentAdapter extends FragmentPagerAdapter {
    private Fragment[] listF;

    public HeroPagerFragmentAdapter(FragmentManager fm, Fragment[] listF) {
        super(fm);
        this.listF = listF;
    }

    @Override
    public Fragment getItem(int position) {
        return listF[position];
    }

    @Override
    public int getCount() {
        return listF.length;
    }
}
