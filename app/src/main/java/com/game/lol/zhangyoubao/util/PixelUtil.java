package com.game.lol.zhangyoubao.util;

import android.content.Context;
import android.content.res.Resources;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/23 12:46
 * 创建描述：单位转换工具类
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class PixelUtil {

    /**
     * dp转px
     *
     * @param context 上下文
     * @param dpValue dp单位值
     * @return
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转dp
     *
     * @param context 上下文
     * @param pxValue px单位值
     * @return
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转px
     *
     * @param context 上下文
     * @param spValue sp单位值
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        Resources r;
        if (context == null) {
            r = Resources.getSystem();
        } else {
            r = context.getResources();
        }
        float fontScale = spValue * r.getDisplayMetrics().scaledDensity;
        return (int) (fontScale + 0.5f);
    }

    /**
     * px转sp
     *
     * @param context 上下文
     * @param pxValue px单位值
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

}
