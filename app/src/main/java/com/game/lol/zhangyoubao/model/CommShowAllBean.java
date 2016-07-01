package com.game.lol.zhangyoubao.model;

import java.util.List;

/**
 * ====================================
 * 作者：王月丽
 * 版本：1.0
 * 创建日期：2016/6/27 11:26
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class CommShowAllBean {

    /**
     * data : [{"id":"721541","user_id":"7264593","sex":"2",
     * "area":"德玛西亚","summoner":"Angle丶冰澄","desc":"今天有开黑的木有，我要往外爬坑了",
     * "pic":"pic/lol/user_shows/e4/e4185ade75bfdcd020ac025f437f3bb7",
     * "good":"0","bad":"0","comment":"0","close_comment":"0","state":"1",
     * "created":"2016-06-27 11:22:59","modified":"2016-06-27 11:22:59",
     * "pic_url":"http://avatar.zhangyoubao.com/pic/lol/user_shows/e4/e4185ade75bfdcd020ac025f437f3bb7",
     * "pic_url_small":"http://avatar.zhangyoubao.com/pic/lol/user_shows/e4/e4185ade75bfdcd020ac025f437f3bb7_small",
     * "nickname":"100％\u2033真心",
     * "avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/e1/576e8c997264593s.crop_image",
     * "userLogoFrameId":0,"user_logo_frame_id":0},
     * page_session : 1466998020
     * code : 200
     * message : ok
     * api : 1
     */

    private int page_session;
    private int code;
    private String message;
    private int api;
    /**
     * id : 721541
     * user_id : 7264593
     * sex : 2
     * area : 德玛西亚
     * summoner : Angle丶冰澄
     * desc : 今天有开黑的木有，我要往外爬坑了
     * pic : pic/lol/user_shows/e4/e4185ade75bfdcd020ac025f437f3bb7
     * good : 0
     * bad : 0
     * comment : 0
     * close_comment : 0
     * state : 1
     * created : 2016-06-27 11:22:59
     * modified : 2016-06-27 11:22:59
     * pic_url : http://avatar.zhangyoubao.com/pic/lol/user_shows/e4/e4185ade75bfdcd020ac025f437f3bb7
     * pic_url_small : http://avatar.zhangyoubao.com/pic/lol/user_shows/e4/e4185ade75bfdcd020ac025f437f3bb7_small
     * nickname : 100％″真心
     * avatar : http://avatar.zhangyoubao.com/pic/user/avatar/e1/576e8c997264593s.crop_image
     * userLogoFrameId : 0
     * user_logo_frame_id : 0
     */

    private List<DataBean> data;

    public int getPage_session() {
        return page_session;
    }

    public void setPage_session(int page_session) {
        this.page_session = page_session;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getApi() {
        return api;
    }

    public void setApi(int api) {
        this.api = api;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String user_id;
        private String sex;
        private String area;
        private String summoner;
        private String desc;
        private String pic;
        private String good;
        private String bad;
        private String comment;
        private String close_comment;
        private String state;
        private String created;
        private String modified;
        private String pic_url;
        private String pic_url_small;
        private String nickname;
        private String avatar;
        private int userLogoFrameId;
        private int user_logo_frame_id;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", user_id='" + user_id + '\'' +
                    ", sex='" + sex + '\'' +
                    ", area='" + area + '\'' +
                    ", summoner='" + summoner + '\'' +
                    ", desc='" + desc + '\'' +
                    ", pic='" + pic + '\'' +
                    ", good='" + good + '\'' +
                    ", bad='" + bad + '\'' +
                    ", comment='" + comment + '\'' +
                    ", close_comment='" + close_comment + '\'' +
                    ", state='" + state + '\'' +
                    ", created='" + created + '\'' +
                    ", modified='" + modified + '\'' +
                    ", pic_url='" + pic_url + '\'' +
                    ", pic_url_small='" + pic_url_small + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", userLogoFrameId=" + userLogoFrameId +
                    ", user_logo_frame_id=" + user_logo_frame_id +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getSummoner() {
            return summoner;
        }

        public void setSummoner(String summoner) {
            this.summoner = summoner;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getGood() {
            return good;
        }

        public void setGood(String good) {
            this.good = good;
        }

        public String getBad() {
            return bad;
        }

        public void setBad(String bad) {
            this.bad = bad;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getClose_comment() {
            return close_comment;
        }

        public void setClose_comment(String close_comment) {
            this.close_comment = close_comment;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getPic_url_small() {
            return pic_url_small;
        }

        public void setPic_url_small(String pic_url_small) {
            this.pic_url_small = pic_url_small;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getUserLogoFrameId() {
            return userLogoFrameId;
        }

        public void setUserLogoFrameId(int userLogoFrameId) {
            this.userLogoFrameId = userLogoFrameId;
        }

        public int getUser_logo_frame_id() {
            return user_logo_frame_id;
        }

        public void setUser_logo_frame_id(int user_logo_frame_id) {
            this.user_logo_frame_id = user_logo_frame_id;
        }
    }
}
