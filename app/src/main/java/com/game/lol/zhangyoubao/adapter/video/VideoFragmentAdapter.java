package com.game.lol.zhangyoubao.adapter.video;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/23 22:54
 * 创建描述： 视频界面里的FragmentAdapter
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class VideoFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> listF;

    public VideoFragmentAdapter(FragmentManager fm, List<Fragment> listF) {
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
