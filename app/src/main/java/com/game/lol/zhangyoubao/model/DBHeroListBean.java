package com.game.lol.zhangyoubao.model;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/29 15:54
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class DBHeroListBean {

    /**
     * area : 提亚玛特战争学院
     * duoname : Syndra
     * filter : 法师
     * free : 0
     * id : 8
     * keyword : 辛德拉 暗黑元首 法系 远程 球女 法师 玩蛋
     * money : 6300
     * name : 辛德拉
     * nickname : 暗黑元首
     * nickpinyin : anheiyuanshou
     * pic_url : http://pic.woqugame.com/lol/roles/Syndra.jpg
     * point : 4500
     * publish : 104
     */

    private String area;
    private String duoname;
    private String filter;
    private String free;
    private String id;
    private String keyword;
    private String money;
    private String name;
    private String nickname;
    private String nickpinyin;
    private String pic_url;
    private String point;
    private String publish;

    public DBHeroListBean() {
    }

    public DBHeroListBean(String area, String duoname, String filter, String free, String id, String keyword, String money, String name, String nickname, String nickpinyin, String pic_url, String point, String publish) {
        this.area = area;
        this.duoname = duoname;
        this.filter = filter;
        this.free = free;
        this.id = id;
        this.keyword = keyword;
        this.money = money;
        this.name = name;
        this.nickname = nickname;
        this.nickpinyin = nickpinyin;
        this.pic_url = pic_url;
        this.point = point;
        this.publish = publish;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDuoname() {
        return duoname;
    }

    public void setDuoname(String duoname) {
        this.duoname = duoname;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickpinyin() {
        return nickpinyin;
    }

    public void setNickpinyin(String nickpinyin) {
        this.nickpinyin = nickpinyin;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "DBHeroListBean{" +
                "area='" + area + '\'' +
                ", duoname='" + duoname + '\'' +
                ", filter='" + filter + '\'' +
                ", free='" + free + '\'' +
                ", id='" + id + '\'' +
                ", keyword='" + keyword + '\'' +
                ", money='" + money + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", nickpinyin='" + nickpinyin + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", point='" + point + '\'' +
                ", publish='" + publish + '\'' +
                '}';
    }
}
