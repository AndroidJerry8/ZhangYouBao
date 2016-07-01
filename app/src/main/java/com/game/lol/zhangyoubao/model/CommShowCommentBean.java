package com.game.lol.zhangyoubao.model;

import java.util.List;

/**
 * ====================================
 * 作者：王月丽
 * 版本：1.0
 * 创建日期：2016/6/28 16:27
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class CommShowCommentBean {

    /**
     * data : [{"id":"17534155","user_id":"24311735","content":"提供号可以带飞","created":"2016-06-28 17:41:39","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/default_new_s.jpg","nickname":"带人装逼带入飞","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0},{"id":"17531968","user_id":"19481750","content":"为啥俺戴帽子最后一个扣都觉得好紧[生气]","created":"2016-06-28 16:01:55","good":"1","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/4c/56c0741619481750s.crop_image","nickname":"oldYasuo","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0},{"id":"17531733","user_id":"6470520","content":"说多了都是泪","created":"2016-06-28 15:48:49","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/a7/552ef74a6470520s.crop_image","nickname":"用情写后续","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 17534155
     * user_id : 24311735
     * content : 提供号可以带飞
     * created : 2016-06-28 17:41:39
     * good : 0
     * user_avatar : http://avatar.zhangyoubao.com/pic/user/avatar/default_new_s.jpg
     * nickname : 带人装逼带入飞
     * userLogoFrameId : 0
     * user_logo_frame_id : 0
     * liked : 0
     */

    private List<DataBean> data;

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
        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", user_id='" + user_id + '\'' +
                    ", content='" + content + '\'' +
                    ", created='" + created + '\'' +
                    ", good='" + good + '\'' +
                    ", user_avatar='" + user_avatar + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", userLogoFrameId=" + userLogoFrameId +
                    ", user_logo_frame_id=" + user_logo_frame_id +
                    ", liked=" + liked +
                    '}';
        }

        private String id;
        private String user_id;
        private String content;
        private String created;
        private String good;
        private String user_avatar;
        private String nickname;
        private int userLogoFrameId;
        private int user_logo_frame_id;
        private int liked;

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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getGood() {
            return good;
        }

        public void setGood(String good) {
            this.good = good;
        }

        public String getUser_avatar() {
            return user_avatar;
        }

        public void setUser_avatar(String user_avatar) {
            this.user_avatar = user_avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
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

        public int getLiked() {
            return liked;
        }

        public void setLiked(int liked) {
            this.liked = liked;
        }
    }
}
