package com.game.lol.zhangyoubao.model;

import java.util.List;

/**
 * ====================================
 * 作者：王月丽
 * 版本：1.0
 * 创建日期：2016/6/27 9:44
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class CommShowClassBean {

    /**
     * data : [{"id":"17502234","user_id":"19910120","content":"玩加Q1759242646","created":"2016-06-26 17:12:36","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg","nickname":"bgjbmn","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0},{"id":"17486295","user_id":"8096953","content":"上学也受周围情侣伤","created":"2016-06-25 13:50:39","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/fb/576d565c8096953s.crop_image","nickname":"328578165","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0},{"id":"17481261","user_id":"24219742","content":"无聊","created":"2016-06-25 09:02:21","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/4a/576cd6f024219742s.crop_image","nickname":"郭日忠","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0},{"id":"17480897","user_id":"24235817","content":"ZZ","created":"2016-06-25 08:23:38","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/05/576dc95124235817s.jpg","nickname":"俏丽畔一","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0},{"id":"17480849","user_id":"18106683","content":"l","created":"2016-06-25 08:20:13","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg","nickname":"陌生的孤单","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0},{"id":"17480584","user_id":"23277026","content":"。。","created":"2016-06-25 07:49:51","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg","nickname":"坑圣ol","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0},{"id":"17480571","user_id":"24235963","content":"呵呵","created":"2016-06-25 07:48:13","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/bc/576dc51bD95D1981D6B7FD6AE844C4D1C3FC4A7As.jpg","nickname":"你要陪我走下去吗","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0},{"id":"17480432","user_id":"21125747","content":"毛线啊","created":"2016-06-25 07:34:20","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/b3/575aa44121125747s.crop_image","nickname":"情绪不亦燥","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0},{"id":"17480271","user_id":"13010612","content":"丰富","created":"2016-06-25 07:14:54","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/a4/576dbf8a13010612s.crop_image","nickname":"3187002442","userLogoFrameId":"5","user_logo_frame_id":"5","liked":0},{"id":"17479718","user_id":"22593663","content":"啦啦啦啦啦啦啦人","created":"2016-06-25 04:06:50","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/74/5760252822593663s.jpg","nickname":"超有戏m","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0},{"id":"17479526","user_id":"23818311","content":"有前途","created":"2016-06-25 02:20:23","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/f9/5756874cEF1FF820F722CA075E93AB2C0E63EF94s.jpg","nickname":"本尊昊天","userLogoFrameId":"2","user_logo_frame_id":"2","liked":0},{"id":"17479375","user_id":"20443883","content":"呵呵","created":"2016-06-25 01:36:43","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg","nickname":"foreveoy","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0},{"id":"17478981","user_id":"22856510","content":"看别人女票","created":"2016-06-25 00:36:16","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/d3/5752618d22856510s.crop_image","nickname":"烏爾齊奧拉","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0},{"id":"17478704","user_id":"21136684","content":"帅","created":"2016-06-25 00:07:23","good":"0","user_avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg","nickname":"狂战丶小荣","userLogoFrameId":0,"user_logo_frame_id":0,"liked":0}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 17502234
     * user_id : 19910120
     * content : 玩加Q1759242646
     * created : 2016-06-26 17:12:36
     * good : 0
     * user_avatar : http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg
     * nickname : bgjbmn
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
