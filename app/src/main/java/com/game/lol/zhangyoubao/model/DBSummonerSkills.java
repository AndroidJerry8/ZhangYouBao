package com.game.lol.zhangyoubao.model;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/29 16:04
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class DBSummonerSkills {

    /**
     * cold : 210
     * desc : 我方防御塔：回复速度得到巨幅提高,持续8秒.敌方防御塔：减少80%的攻击力,持续8秒.支持的游戏模式： 统治战场
     * id : 1734
     * level : 1
     * name : 卫戌部队
     * pic : lol/summoner/1734.jpg
     * pic_url : http://pic.woqugame.com/lol/summoner/1734.jpg
     * weight : 1
     */

    private String cold;
    private String desc;
    private String id;
    private String level;
    private String name;
    private String pic;
    private String pic_url;
    private String weight;

    public DBSummonerSkills() {
    }

    public DBSummonerSkills(String cold, String desc, String id, String level, String name, String pic, String pic_url, String weight) {
        this.cold = cold;
        this.desc = desc;
        this.id = id;
        this.level = level;
        this.name = name;
        this.pic = pic;
        this.pic_url = pic_url;
        this.weight = weight;
    }

    public String getCold() {
        return cold;
    }

    public void setCold(String cold) {
        this.cold = cold;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
