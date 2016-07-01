package com.game.lol.zhangyoubao.adapter.info;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/22 14:38
 * 创建描述：资讯界面的FragmentAdapter
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class InfoPagerFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> listF;

    public InfoPagerFragmentAdapter(FragmentManager fm, List<Fragment> listF) {
        super(fm);
        this.listF = listF;
    }

    @Override
    public Fragment getItem(int position) {
        return listF.get(position);
    }

    @Override
    public int getCount() {
        return listF.size();
    }
}
