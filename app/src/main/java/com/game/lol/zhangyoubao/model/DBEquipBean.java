package com.game.lol.zhangyoubao.model;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/21 16:59
 * 创建描述：数据库装备的Bean类
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class DBEquipBean {
    /**
     * area : 召唤峡谷
     * by_id :
     * filter : 工具 视野饰品 其他 主动 移动 其他移动
     * for_id :
     * _id : 13156
     * name : 骨齿项链-骨齿图腾
     * pic_url : http://pic.woqugame.com/lol/equipment/13156.jpg
     * price : 0
     * tprice : 0
     */
    private String area;
    private String attr;
    private String by_id;
    private String filter;
    private String for_id;
    private String name;
    private String pic_url;
    private String price;
    private String tprice;

    public DBEquipBean() {

    }

    public DBEquipBean(String area, String attr, String by_id, String filter, String for_id, String name, String pic_url, String price, String tprice) {
        this.area = area;
        this.attr = attr;
        this.by_id = by_id;
        this.filter = filter;
        this.for_id = for_id;
        this.name = name;
        this.pic_url = pic_url;
        this.price = price;
        this.tprice = tprice;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getBy_id() {
        return by_id;
    }

    public void setBy_id(String by_id) {
        this.by_id = by_id;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFor_id() {
        return for_id;
    }

    public void setFor_id(String for_id) {
        this.for_id = for_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTprice() {
        return tprice;
    }

    public void setTprice(String tprice) {
        this.tprice = tprice;
    }

    @Override
    public String toString() {
        return "DBEquipBean{" +
                ", area='" + area + '\'' +
                ", attr='" + attr + '\'' +
                ", by_id='" + by_id + '\'' +
                ", filter='" + filter + '\'' +
                ", for_id='" + for_id + '\'' +
                ", name='" + name + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", price='" + price + '\'' +
                ", tprice='" + tprice + '\'' +
                '}';
    }
}
