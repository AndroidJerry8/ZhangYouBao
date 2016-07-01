package com.game.lol.zhangyoubao.fragment.more;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.adapter.more.MoreRecyclerViewAdapter;
import com.game.lol.zhangyoubao.model.MoreBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/22 10:17
 * 创建描述：更多界面的Fragment
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class MoreFragment extends Fragment {

    @BindView(R.id.rv_more)
    RecyclerView rvMore;
    private FragmentManager fm;
    private MoreRecyclerViewAdapter mAdapter;
    private List<MoreBean> list;
    private String[] titles;
    private int[] images = new int[]{R.mipmap.more_fight_record_icon, R.mipmap.match_schedule_icon
            , R.mipmap.more_hero_icon, R.mipmap.more_player_icon, R.mipmap.more_topic_icon
            , R.mipmap.more_talent_icon, R.mipmap.more_rune_icon, R.mipmap.more_skills_icon
            , R.mipmap.more_equipment_icon, R.mipmap.more_ring_icon, R.mipmap.more_img_icon
            , R.mipmap.more_novel_icon
            , R.mipmap.store_img, R.mipmap.mini_game_icon};
    private Context context;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        fm = getChildFragmentManager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, null);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rvMore.setLayoutManager(new GridLayoutManager(context, 4));
        list = new ArrayList<>();
        titles = getResources().getStringArray(R.array.titles);
        for (int i = 0; i < titles.length; i++) {
            MoreBean bean = new MoreBean();
            bean.title = titles[i];
            bean.imageId = images[i];
            list.add(bean);
        }
        list.add(new MoreBean());
        list.add(new MoreBean());
        mAdapter = new MoreRecyclerViewAdapter(list, context);
        rvMore.setAdapter(mAdapter);
    }
}
