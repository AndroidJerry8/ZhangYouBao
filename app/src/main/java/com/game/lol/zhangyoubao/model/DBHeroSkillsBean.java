package com.game.lol.zhangyoubao.model;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/29 16:00
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class DBHeroSkillsBean {

    /**
     * blood :
     * cold : 14/14/14/14/14
     * desc : 被动：墨菲特获得10/15/20/25/30%额外护甲。主动：普通攻击对目标和附近的单位造成15/30/45/60/75(+0.1AP)(+0.1护甲)的额外物理伤害
     * energy :
     * id : 2
     * key : W
     * mana : 25/25/25/25/25 法力
     * name : 野蛮打击[W]
     * passive : 0
     * pic_url : http://pic.woqugame.com/lol/skills/2.jpg
     * role_id : 63
     * video_path : 0054_03.mp4
     */

    private String blood;
    private String cold;
    private String desc;
    private String energy;
    private String id;
    private String key;
    private String mana;
    private String name;
    private String passive;
    private String pic_url;
    private String role_id;
    private String video_path;

    public DBHeroSkillsBean() {
    }

    public DBHeroSkillsBean(String blood, String cold, String desc, String energy, String id, String key, String mana, String name, String passive, String pic_url, String role_id, String video_path) {
        this.blood = blood;
        this.cold = cold;
        this.desc = desc;
        this.energy = energy;
        this.id = id;
        this.key = key;
        this.mana = mana;
        this.name = name;
        this.passive = passive;
        this.pic_url = pic_url;
        this.role_id = role_id;
        this.video_path = video_path;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
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

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMana() {
        return mana;
    }

    public void setMana(String mana) {
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassive() {
        return passive;
    }

    public void setPassive(String passive) {
        this.passive = passive;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getVideo_path() {
        return video_path;
    }

    public void setVideo_path(String video_path) {
        this.video_path = video_path;
    }

    @Override
    public String toString() {
        return "DBHeroSkillsBean{" +
                "blood='" + blood + '\'' +
                ", cold='" + cold + '\'' +
                ", desc='" + desc + '\'' +
                ", energy='" + energy + '\'' +
                ", id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", mana='" + mana + '\'' +
                ", name='" + name + '\'' +
                ", passive='" + passive + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", role_id='" + role_id + '\'' +
                ", video_path='" + video_path + '\'' +
                '}';
    }
}
