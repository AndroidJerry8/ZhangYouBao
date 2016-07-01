package com.game.lol.zhangyoubao.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/23 12:46
 * 创建描述：请求网络状态的工具类
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class NetWorkStateUtil {
    private static Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");// 4.0模拟器屏蔽掉该权限

    /**
     * 检查网络
     *
     * @param context
     * @return
     */
    public static boolean checkNetWork(Context context) {
        // ConnectivityManager--系统服务
        // ①判断WIFI链接吗
        boolean isWIFI = isWIFIConnectivity(context);
        // ②判断MOBILE链接吗
        boolean isMOBILE = isMOBILEConnectivity(context);

        // 如果没有网络
        if (!isMOBILE && !isWIFI) {
            return false;
        }
        return true;
    }

    /**
     * 判断MOBILE链接
     *
     * @param context
     * @return
     */
    private static boolean isMOBILEConnectivity(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // MOBILE链接的描述信息
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    /**
     * 判断WIFI链接状态
     *
     * @param context
     * @return
     */
    private static boolean isWIFIConnectivity(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // WIFI链接的描述信息
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }
}
