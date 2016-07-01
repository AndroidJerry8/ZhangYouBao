package com.game.lol.zhangyoubao.fragment.hero;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.constant.Type;
import com.game.lol.zhangyoubao.util.RetrofitUtil;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/30 10:12
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class HeroDiscountFragment extends Fragment {
    private static final String TAG = "HeroDiscountFragment";
    @BindView(R.id.wb_discount)
    WebView wbDiscount;
    @BindView(R.id.ptrf_discount)
    PullToRefreshScrollView ptrfDiscount;
    @BindView(R.id.iv_loading)
    ImageView ivLoading;
    @BindView(R.id.tv_loading_failed)
    TextView tvLoadingFailed;
    private Context context;
    private RetrofitUtil retrofitUtil;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int roleid = msg.arg1;
            Toast.makeText(context, "点击条目ID:" + roleid, Toast.LENGTH_SHORT).show();
        }
    };
    private Animation animation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        retrofitUtil = new RetrofitUtil(context);
        animation = AnimationUtils.loadAnimation(context, R.anim.anim_rotate_loading);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hero_discount_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ivLoading.setAnimation(animation);
        initWebViewData();
        initListener();
    }

    private void initListener() {
        ptrfDiscount.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        ptrfDiscount.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
                initWebViewData();
            }
        });
    }

    private void initWebViewData() {
        Log.i(TAG, "initWebViewData: ");
        ivLoading.setVisibility(View.VISIBLE);
        tvLoadingFailed.setVisibility(View.GONE);
        wbDiscount.setVisibility(View.GONE);
        retrofitUtil.getLOLStringDataFromNet(Type.ROLES_SERVICE, Type.discount, null, new RetrofitUtil.CallBack<String>() {
            @Override
            public void onLoadingDataComplete(String body) {
                try {
                    JSONObject object = new JSONObject(body);
                    JSONObject data = object.getJSONObject("data");
                    String url = data.getString("url");
                    //设置让网页在WebView控件内加载
                    wbDiscount.setWebViewClient(new WebViewClient() {
                        @Override
                        public boolean shouldOverrideUrlLoading(WebView view, String url) {
                            view.loadUrl(url);
                            return super.shouldOverrideUrlLoading(view, url);
                        }
                    });
                    WebSettings settings = wbDiscount.getSettings();
                    //设置支持Js语言
                    settings.setJavaScriptEnabled(true);
                    //调用Js里的方法
                    wbDiscount.addJavascriptInterface(new Object() {
                        @JavascriptInterface
                        public void showHeroDetail(int roleid) {
                            Message message = handler.obtainMessage();
                            message.arg1 = roleid;
                            handler.sendMessage(message);
                        }
                    }, "android");
                    wbDiscount.loadUrl(url);
                    wbDiscount.setVisibility(View.VISIBLE);
                    ivLoading.clearAnimation();
                    ivLoading.setVisibility(View.GONE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ptrfDiscount.onRefreshComplete();
            }

            @Override
            public void onLoadingDataFailed(Throwable t) {
                ivLoading.clearAnimation();
                ivLoading.setVisibility(View.GONE);
                tvLoadingFailed.setVisibility(View.VISIBLE);
                Toast.makeText(context, "WebView数据获取失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
