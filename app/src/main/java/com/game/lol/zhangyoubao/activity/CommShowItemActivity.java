package com.game.lol.zhangyoubao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.adapter.community.CommShowItemLvAdapter;
import com.game.lol.zhangyoubao.constant.Key;
import com.game.lol.zhangyoubao.constant.Type;
import com.game.lol.zhangyoubao.constant.Url;
import com.game.lol.zhangyoubao.model.CommShowCommentBean;
import com.game.lol.zhangyoubao.service.INetRequestService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommShowItemActivity extends AppCompatActivity {

    @BindView(R.id.lv_comm_item_comment)
    ListView lvCommItemComment;


    String id;
    List<CommShowCommentBean.DataBean> commentList = new ArrayList<>();

    CommShowItemLvAdapter commShowItemLvAdapter;
    @BindView(R.id.show_comment_pb)
    ProgressBar showCommentPb;
    @BindView(R.id.rl_nocomment)
    RelativeLayout rlNocomment;
    @BindView(R.id.rl_comment_line)
    RelativeLayout rlCommentLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm_show_item);
        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");
        ButterKnife.bind(this);
        setAdapter();
        initData();
        setListener();

    }

    private void setListener() {
        rlNocomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommShowItemActivity.this, LoginActivity.class));
            }
        });
        rlCommentLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommShowItemActivity.this, LoginActivity.class));
            }
        });
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url.URL_LOL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Map<String, String> map = new HashMap<>();
        long t_value = Url.get_t_Value();
        long p_value = Url.get_p_Value(t_value);
        map.put("token", "");
        map.put(Key.page, "1");
        map.put("id", id);
        map.put("userid", "");
        map.put(Key.i_, Url.get_i_Value() + "");
        map.put(Key.t_, t_value + "");
        map.put(Key.p_, p_value + "");
        final Call<CommShowCommentBean> commShowCommentBean = retrofit.create(INetRequestService.class).getCommShowCommentBean(Type.UGCS_SERVICE, Type.userShowComments, map);
        commShowCommentBean.enqueue(new Callback<CommShowCommentBean>() {
            @Override
            public void onResponse(Call<CommShowCommentBean> call, Response<CommShowCommentBean> response) {
                if (response.isSuccessful()) {
                    List<CommShowCommentBean.DataBean> data = response.body().getData();
                    if (data.size()==0) {
                        rlNocomment.setVisibility(View.VISIBLE);
                    }
                    showCommentPb.setVisibility(View.INVISIBLE);
                    commentList.addAll(data);
                    commShowItemLvAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<CommShowCommentBean> call, Throwable t) {
                rlNocomment.setVisibility(View.VISIBLE);
            }
        });

    }

    private void setAdapter() {
        commShowItemLvAdapter = new CommShowItemLvAdapter(this, commentList);
        lvCommItemComment.setAdapter(commShowItemLvAdapter);
        commShowItemLvAdapter.notifyDataSetChanged();
    }
}
