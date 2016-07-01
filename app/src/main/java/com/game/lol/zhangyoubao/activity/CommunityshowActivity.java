package com.game.lol.zhangyoubao.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.adapter.community.CommPwRcvAdapter;
import com.game.lol.zhangyoubao.adapter.community.CommShowContentAdapter;
import com.game.lol.zhangyoubao.constant.Key;
import com.game.lol.zhangyoubao.constant.Type;
import com.game.lol.zhangyoubao.constant.Url;
import com.game.lol.zhangyoubao.model.CommShowAllBean;
import com.game.lol.zhangyoubao.service.INetRequestService;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.orhanobut.logger.Logger;

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

public class CommunityshowActivity extends AppCompatActivity {
    private static final String TAG = "CommunityshowActivity";
    @BindView(R.id.btn_area)
    Button btnArea;
    @BindView(R.id.btn_bang)
    Button btnBang;
    @BindView(R.id.btn_gender)
    Button btnGender;
    @BindView(R.id.btn_publish)
    Button btnPublish;
    @BindView(R.id.rcv_comm_show)
    XRecyclerView rcvCommShow;
    @BindView(R.id.pb_show)
    ProgressBar pbShow;
    @BindView(R.id.ibtn_back)
    ImageButton ibtnBack;
    private PopupWindow pw;
    String[] areas = {"全部大区", "艾欧尼亚", "祖安", "诺克萨斯", "班德尔城", "皮尔特沃夫", "战争学院", "巨神峰", "雷瑟守备",
            "裁决之地", "黑色玫瑰", "暗影岛", "钢铁烈阳",
            "均衡教派", "水晶之痕", "影流", "守望之海", "征服之海", "卡拉曼达", "皮城警备", "比尔吉沃特",
            "德玛西亚", "弗雷尔卓德", "无畏先锋", "恕瑞玛", "扭曲丛林", "巨龙之巢", "教育网专区"};
    String[] bang = {"最新", "日榜", "周榜", "总榜"};
    String[] gender = {"全部", "男", "女"};
    private int page = 1;
    private String order_kind="";
    String area="";
    String sex="";
    private Boolean flag = false;
    CommShowContentAdapter contentAdapter;
    List<CommShowAllBean.DataBean> allList = new ArrayList<>();
    private int width;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_show);
        width = getResources().getDisplayMetrics().widthPixels;
        ButterKnife.bind(this);
        initData(page, "", "", "", allList);
        setAdapter();
        setListener(allList);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setListener(final List<CommShowAllBean.DataBean> aallList) {
        rcvCommShow.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //  flag=true;
                initData(1, order_kind, area, sex, aallList);
            }

            @Override
            public void onLoadMore() {
                initData(++page, order_kind, area, sex, allList);
            }
        });

    }

    private void setAdapter() {
        rcvCommShow.setLayoutManager(new LinearLayoutManager(this));
        contentAdapter = new CommShowContentAdapter(this);
        rcvCommShow.setAdapter(contentAdapter);
        startItemActivity(contentAdapter);
    }

    private void startItemActivity(CommShowContentAdapter contentAdapter) {
        contentAdapter.IShowItemClick(new CommShowContentAdapter.IShowItemClick() {
            @Override
            public void getItemId(View v, String id) {
                Intent intent = new Intent(CommunityshowActivity.this, CommShowItemActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }


    private void initData(int page, String order_kind, String area, String sex, final List<CommShowAllBean.DataBean> aallList) {
        pbShow.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url.URL_LOL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Map<String, String> map = new HashMap<>();
        long t_value = Url.get_t_Value();
        long p_value = Url.get_p_Value(t_value);
        //getUserShows?order_kind=0&area=&page=1&sex=&
        map.put(Key.order_kind, order_kind);
        map.put(Key.area, area);
        map.put(Key.page, page + "");
        map.put(Key.sex, sex);
        map.put(Key.i_, "0");
        map.put(Key.t_, t_value + "");
        map.put(Key.p_, p_value + "");
        Call<CommShowAllBean> getUserShows = retrofit.create(INetRequestService.class)
                .getCommShowAllBean(Type.UGCS_SERVICE, Type.getUserShows, map);
        getUserShows.enqueue(new Callback<CommShowAllBean>() {
            @Override
            public void onResponse(Call<CommShowAllBean> call, Response<CommShowAllBean> response) {
                if (response.isSuccessful()) {

                    if (flag) {
                        aallList.clear();
                        contentAdapter.updataList(aallList);
                        flag = false;
                    }
                    aallList.addAll(response.body().getData());
                    contentAdapter.updataList(aallList);
                }
                pbShow.setVisibility(View.INVISIBLE);
                rcvCommShow.loadMoreComplete();
                rcvCommShow.refreshComplete();
            }

            @Override
            public void onFailure(Call<CommShowAllBean> call, Throwable t) {
                Log.i(TAG, "onFailure : " + t.getMessage());
                Toast.makeText(CommunityshowActivity.this, "检查您的网络设置:" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_area:
                showPopupWindows(btnArea, areas);
                break;
            case R.id.btn_bang:
                showPopupWindows(btnBang, bang);
                break;
            case R.id.btn_gender:
                showPopupWindows(btnGender, gender);
                break;
        }
    }

    private void showPopupWindows(final Button btn, String[] titles) {
        View v = View.inflate(this, R.layout.community_show_popup, null);
        RecyclerView rcv = (RecyclerView) v.findViewById(R.id.rcv_comm_show_pop);
        rcv.setLayoutManager(new GridLayoutManager(this, 3));
        CommPwRcvAdapter pwAdapter = new CommPwRcvAdapter(titles, this);
        rcv.setAdapter(pwAdapter);

        pw = new PopupWindow(v, width, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        pw.setFocusable(true);
        pw.setOutsideTouchable(true);
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.showAsDropDown(btn);
        pwAdapter.ClickCallback(new CommPwRcvAdapter.PwItemClick() {
            @Override
            public void ItemClick(View v, String id) {
                btn.setText(id);
                pw.setFocusable(true);
                refreshList(btn, id);
                Toast.makeText(CommunityshowActivity.this, "====" + id, Toast.LENGTH_SHORT).show();
                Logger.i(id);
                if (pw.isShowing()) {
                    pw.dismiss();
                    pw.update();
                }
            }
        });
        pw.setContentView(rcv);

    }

    private void refreshList(Button btn, String id) {

        switch (btn.getId()) {
            case R.id.btn_area:
                flag = true;
                area = id;
                Logger.i(id + "======================");
                initData(1, order_kind, area, sex, allList);
                break;
            case R.id.btn_bang:
                flag = true;
                if (id.equals("最新")) {
                    order_kind = 0 + "";
                } else if (id.equals("日榜")) {
                    order_kind = 4 + "";
                } else if (id.equals("周榜")) {
                    order_kind = 2 + "";
                } else {
                    order_kind = 3 + "";
                }
                Logger.i(area + "======================");
                initData(1, order_kind, area, sex, allList);
                break;
            case R.id.btn_gender:
                flag = true;
                if (id.equals("男")) {
                    sex = 1 + "";
                } else if (id.equals("女")) {
                    sex = 2 + "";
                } else {
                    sex = "";
                }
                Logger.i(sex + "======================");
                initData(1, order_kind, area, sex, allList);
                break;
        }
    }

}
