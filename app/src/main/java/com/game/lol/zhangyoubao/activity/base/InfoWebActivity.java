package com.game.lol.zhangyoubao.activity.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.game.lol.zhangyoubao.R;

public class InfoWebActivity extends AppCompatActivity {
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_web);
        initView();
        Bundle extras = getIntent().getExtras();
        String url_id = extras.getString("url_id");
        setWeb(url_id);
    }

    private void setWeb(String url_id) {
        WebSettings set = wv.getSettings();
        set.setJavaScriptEnabled(true);
        set.setSupportZoom(true);
        set.setBuiltInZoomControls(true);
        set.setUseWideViewPort(true);
        set.setCacheMode(WebSettings.LOAD_DEFAULT);
        set.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        set.setLoadWithOverviewMode(true);
        set.setAppCacheEnabled(true);
        set.setDomStorageEnabled(true);
        wv.setWebChromeClient(new WebChromeClient());
        wv.loadUrl("http://lol.zhangyoubao.com/mobiles/shareout/"+url_id);
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return false;
            }
        });
    }

    private void initView() {
        wv= (WebView) findViewById(R.id.wv_info_item);

    }
}
