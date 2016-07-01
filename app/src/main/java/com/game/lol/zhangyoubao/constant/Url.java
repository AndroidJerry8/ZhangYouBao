package com.game.lol.zhangyoubao.constant;

import java.util.Date;

/**
 * ====================================
 * 作者：王月丽
 * 版本：1.0
 * 创建日期：2016/6/21 20:38
 * 创建描述：URL 静态常量类
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class Url {

    //a = "api.lol.zhangyoubao.com";
    //b = "pic.zhangyoubao.com";

    public static final String URL_WWW_BASE = "http://www.zhangyoubao.com/";
    public static final String URL_LOL_BASE = "http://lol.zhangyoubao.com/";
    public static final String URL_USER_BASE = "http://user.zhangyoubao.com/";
    public static final String URL_API_BASE = "http://api.lol.zhangyoubao.com/";
    public static final String URL_PIC_BASE = "http://pic.zhangyoubao.com/";

    public static int get_i_Value() {
        return 0;
    }

    public static long get_t_Value() {
        return new Date().getTime();
    }

    public static long get_p_Value(long t_value) {
        return 2345L + 3L * (t_value % 10000L);
    }
}
