package com.game.lol.zhangyoubao.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/27 17:39
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class TimeFormatUtil {
    /**
     * 获取格式化好的当前时间格
     *
     * @return 格式化好的时间。例：1970-01-01 12:20:30
     */
    private static String getCurrentFormatTime() {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        return format.format(new Date());
    }

    /**
     * 获取格式化好的当前时间格
     *
     * @return 格式化好的时间。例：06-01 12:20
     */
    private static String getServiceFormatTime(int published) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
        long time = (long) published * 1000L;
        return format.format(new Date(time));
    }

    /**
     * 获取当前时间格(毫秒)
     *
     * @return 毫秒当前时间
     */
    public static long getCurrentTimeMillis() {
        return new Date().getTime();
    }

    /**
     * 时间格式化方法（判断今天和非今天）
     *
     * @param published 毫秒时间
     * @return 今天 18:30 或 06-26 19:30
     */
    public static String getFormatTime(int published) {
        String serviceTime = getServiceFormatTime(published);   //06-25 18:00
        String systemTime = getCurrentFormatTime();             //06-27 16:00
        if (serviceTime.startsWith(systemTime)) {
            return "今天 " + serviceTime.substring(5, serviceTime.length());
        } else
            return serviceTime;
    }

    /**
     * 时间格式化方法
     *
     * @param published 毫秒时间
     * @return 更新于 06-25
     */
    public static String getVideoFormatTime(int published) {
        String serviceTime = getServiceFormatTime(published);   //06-25 18:00
        return "更新于 " + serviceTime.substring(0, 5);
    }

}
