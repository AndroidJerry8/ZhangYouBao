package com.game.lol.zhangyoubao.model;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/29 16:02
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class DBServerListBean {

    /**
     * fn : 无畏先锋
     * id : 12
     * sn : 网通四
     * snEn : wt4
     */

    private String fn;
    private String id;
    private String sn;
    private String snEn;

    public DBServerListBean() {
    }

    public DBServerListBean(String fn, String id, String sn, String snEn) {
        this.fn = fn;
        this.id = id;
        this.sn = sn;
        this.snEn = snEn;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSnEn() {
        return snEn;
    }

    public void setSnEn(String snEn) {
        this.snEn = snEn;
    }
}
