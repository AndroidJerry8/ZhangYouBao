package com.game.lol.zhangyoubao.fragment.hero;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.adapter.hero.HeroAllRCVAdapter;
import com.game.lol.zhangyoubao.db.DBHelperDao;
import com.game.lol.zhangyoubao.model.DBHeroListBean;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/28 19:29
 * 创建描述：英雄界面里我的英雄Fragment
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class HeroPagerFragment3 extends Fragment implements View.OnClickListener {

    @BindView(R.id.btn_type)
    RelativeLayout btnType;
    @BindView(R.id.rv_all_hero)
    RecyclerView rvAllHero;
    @BindView(R.id.btn_tv_type)
    TextView btnTvType;
    private Context context;
    private boolean isPressed = false;
    private DBHelperDao dbHelperDao;
    private HeroAllRCVAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        dbHelperDao = DBHelperDao.getInstance(context).openDB();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hero_pager_fragment3, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rvAllHero.setLayoutManager(new GridLayoutManager(context, 4));
        initDataAndAdapter();
        btnType.setOnClickListener(this);
    }

    private void initDataAndAdapter() {

        List<DBHeroListBean> list = dbHelperDao.queryHeroListAll(null, null, null);
        Collections.sort(list, new Comparator<DBHeroListBean>() {
            @Override
            public int compare(DBHeroListBean lhs, DBHeroListBean rhs) {
                return Integer.parseInt(rhs.getPublish()) - Integer.parseInt(lhs.getPublish());
            }
        });
        adapter = new HeroAllRCVAdapter(context, list);
        rvAllHero.setAdapter(adapter);
        adapter.setOnItemClickListener(new HeroAllRCVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int itemId) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "点击了条目ID：" + itemId, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_type:
                if (!isPressed) {
                    btnTvType.setTextColor(Color.rgb(92, 157, 245));
                    btnTvType.setBackgroundResource(R.drawable.filter_press);
                    btnType.setBackgroundColor(Color.rgb(234, 234, 234));
                    isPressed = true;
                } else {
                    btnTvType.setTextColor(Color.rgb(138, 138, 138));
                    btnTvType.setBackgroundResource(R.drawable.filter_normal);
                    btnType.setBackgroundColor(Color.rgb(244, 244, 244));
                    isPressed = false;
                }
                break;
        }
    }
}
