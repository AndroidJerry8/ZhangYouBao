package com.game.lol.zhangyoubao.fragment.video;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.adapter.video.VideoRecyclerViewAdapter;
import com.game.lol.zhangyoubao.constant.Key;
import com.game.lol.zhangyoubao.constant.Type;
import com.game.lol.zhangyoubao.model.VideoListBean;
import com.game.lol.zhangyoubao.model.VideoUpdateBean;
import com.game.lol.zhangyoubao.util.RetrofitUtil;

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
 * 创建日期：2016/6/23 22:03
 * 创建描述：视频界面里ViewPager里嵌套的Fragment
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class VideoPagerFragment extends Fragment {

    @BindView(R.id.rv_item)
    RecyclerView rvItem;
    //    private RetrofitUtil<VideoUpdateBean> updateBeanRetrofitUtil;
    private VideoRecyclerViewAdapter adapter;
    private Context context;
    private List<VideoListBean.DataBean.CatwordIdBean> videoListBeanList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        Bundle bundle = getArguments();
        VideoListBean.DataBean data = bundle.getParcelable("data");
        videoListBeanList = (ArrayList) data.getCatword_id();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.video_pager_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rvItem.setLayoutManager(new GridLayoutManager(context, 3));
        setAdapter();
    }


    private void setAdapter() {
        adapter = new VideoRecyclerViewAdapter(context, videoListBeanList);
        rvItem.setAdapter(adapter);
        adapter.setOnItemClickListener(new VideoRecyclerViewAdapter.OnItemClickListener() {
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
