package com.game.lol.zhangyoubao.activity.base;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/21 20:58
 * 创建描述：BaseActivity 基类
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class BaseActivity extends AppCompatActivity {
    public Toast mToast;
    public int mScreenDpi;      //屏幕DPI
    public int mScreenWidth;     //屏幕宽度
    public int mScreenHeight;    //屏幕宽度
    private long[] mHits = new long[2]; // 数组长度代表点击次数

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mScreenDpi = displayMetrics.densityDpi;
        mScreenWidth = displayMetrics.widthPixels;
        mScreenHeight = displayMetrics.heightPixels;
    }

    /**
     * Toast输出
     *
     * @param text
     */
    public void ShowToast(final String text) {
        if (!TextUtils.isEmpty(text)) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mToast == null)
                        mToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
                    else
                        mToast.setText(text);
                    mToast.show();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        doubleClickFinish();
    }

    private long afterTIme = 0;

    /**
     * 再次点击退出程序
     */
    public void doubleClickFinish() {
//        System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);
//        mHits[mHits.length - 1] = SystemClock.uptimeMillis();
        long currTime = SystemClock.uptimeMillis();
        long time = currTime - afterTIme;
        if (time < 1000) {
            finish();
        } else {
            afterTIme = currTime;
            ShowToast("再次点击退出程序！");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
