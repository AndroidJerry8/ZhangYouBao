package com.game.lol.zhangyoubao.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.activity.base.BaseActivity;
import com.game.lol.zhangyoubao.fragment.CommunityFragment;
import com.game.lol.zhangyoubao.fragment.hero.HeroFragment;
import com.game.lol.zhangyoubao.fragment.info.InfoFragment;
import com.game.lol.zhangyoubao.fragment.more.MoreFragment;
import com.game.lol.zhangyoubao.fragment.video.VideoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.ibtn_person_center)
    ImageButton ibtnPersonCenter;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ibtn_search)
    ImageButton ibtnSearch;
    @BindView(R.id.ibtn_video_down)
    ImageButton ibtnVideoDown;
    @BindView(R.id.fragment_content)
    FrameLayout fragmentContent;
    @BindView(R.id.rb_information)
    RadioButton rbInformation;
    @BindView(R.id.rb_video)
    RadioButton rbVideo;
    @BindView(R.id.rb_hero)
    RadioButton rbHero;
    @BindView(R.id.rb_community)
    RadioButton rbCommunity;
    @BindView(R.id.rb_more)
    RadioButton rbMore;
    @BindView(R.id.rg_home_tab)
    RadioGroup rgHomeTab;

    private Fragment[] listF;
    private FragmentManager fm;
    private int index = 0;  //点击的RadioButtonTab标记
    private int currIndex = 0;  //当前的RadioButtonTab标记

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initTabFragment();

        setListener();
    }

    private void setListener() {
        rgHomeTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_information:
                        ibtnVideoDown.setVisibility(View.GONE);
                        ibtnSearch.setVisibility(View.VISIBLE);
                        tvTitle.setText(R.string.toolbar_information);
                        index = 0;
                        break;
                    case R.id.rb_video:
                        ibtnVideoDown.setVisibility(View.VISIBLE);
                        ibtnSearch.setVisibility(View.GONE);
                        tvTitle.setText(R.string.toolbar_video);
                        index = 1;
                        break;
                    case R.id.rb_hero:
                        ibtnVideoDown.setVisibility(View.GONE);
                        ibtnSearch.setVisibility(View.GONE);
                        tvTitle.setText(R.string.toolbar_hero);
                        index = 2;
                        break;
                    case R.id.rb_community:
                        ibtnVideoDown.setVisibility(View.GONE);
                        ibtnSearch.setVisibility(View.GONE);
                        tvTitle.setText(R.string.toolbar_community);
                        index = 3;
                        break;
                    case R.id.rb_more:
                        ibtnVideoDown.setVisibility(View.GONE);
                        ibtnSearch.setVisibility(View.GONE);
                        tvTitle.setText(R.string.toolbar_more);
                        index = 4;
                        break;
                }
                //当前页不等于点击的页面时
                if (currIndex != index) {
                    //隐藏掉当前页
                    FragmentTransaction transaction = fm.beginTransaction().hide(listF[currIndex]);
                    if (!listF[index].isAdded()) {
                        transaction.add(R.id.fragment_content, listF[index]);
                    }
                    //显示点击的那页
                    transaction.show(listF[index]).commit();
                }
                //更新当前页标记
                currIndex = index;
            }
        });
    }

    /**
     * 初始化FragmentTab
     */
    private void initTabFragment() {
        fm = getSupportFragmentManager();
        InfoFragment infoFragment = new InfoFragment();
        VideoFragment videoFragment = new VideoFragment();
        HeroFragment heroFragment = new HeroFragment();
        CommunityFragment communityFragment = new CommunityFragment();
        MoreFragment moreFragment = new MoreFragment();
        //初始化Fragment数组
        listF = new Fragment[]{infoFragment, videoFragment, heroFragment, communityFragment, moreFragment};
        //默认标题
        tvTitle.setText("新闻资讯");
        //默认显示资讯Fragment
        fm.beginTransaction().add(R.id.fragment_content, listF[0]).show(listF[0]).commit();
        //默认选择资讯Tab
        rbInformation.setChecked(true);
    }

    /**
     * ToolBar里 个人中心、搜索、下载的点击事件
     *
     * @param view
     */
    @OnClick({R.id.ibtn_person_center, R.id.ibtn_search, R.id.ibtn_video_down})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ibtn_person_center:
                break;
            case R.id.ibtn_search:
                break;
            case R.id.ibtn_video_down:
                break;
        }
    }

}
