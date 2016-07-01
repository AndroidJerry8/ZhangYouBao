package com.game.lol.zhangyoubao.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.activity.CommunityshowActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/22 10:16
 * 创建描述：社区界面的Fragment
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class CommunityFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.cv_zhenrenxiu)
    CardView cvZhenrenxiu;
    @BindView(R.id.cv_shaiwanfa)
    CardView cvShaiwanfa;
    @BindView(R.id.cv_zhaozhanyou)
    CardView cvZhaozhanyou;
    private FragmentManager fm;
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
        View view = inflater.inflate(R.layout.fragment_community, null);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initListener();
    }

    private void initListener() {
        cvZhenrenxiu.setOnClickListener(this);
        cvShaiwanfa.setOnClickListener(this);
        cvZhaozhanyou.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cv_zhenrenxiu:
//                Toast.makeText(context, "点击了真人秀", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, CommunityshowActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_shaiwanfa:
                Toast.makeText(context, "点击了晒玩法", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cv_zhaozhanyou:
                Toast.makeText(context, "点击了找战友", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
