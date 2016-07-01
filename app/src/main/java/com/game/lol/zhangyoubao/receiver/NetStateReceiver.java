package com.game.lol.zhangyoubao.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/23 11:40
 * 创建描述：网络状态监听的Receiver
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class NetStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "网络状态发生改变", Toast.LENGTH_SHORT).show();
    }
}
