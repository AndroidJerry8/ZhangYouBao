package com.game.lol.zhangyoubao.model;

import java.util.List;

/**
 * ====================================
 * 作者：王月丽
 * 版本：1.0
 * 创建日期：2016/6/21 20:46
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */

public class InfoListBean {
    /**
     * code : 200
     * message : ok
     * api : 1
     */
    private int code;
    private String message;
    private int api;
    /**
     * id : 67439
     * title : 掌游宝萌妹私房小魄罗开卖
     * desc : 仅此一家哦~
     * video_url :
     * published : 1466505000
     * weight_new : 200
     * platform : 1
     * pic_url : http://avatar.anzogame.com/pic_v1/lol/news/20160621/spic67439h5768da17.jpg
     * recommend : 1
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
        private String title;
        private String desc;
        private String video_url;
        private int published;
        private String weight_new;
        private String platform;
        private String pic_url;
        private int recommend;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public int getPublished() {
            return published;
        }

        public void setPublished(int published) {
            this.published = published;
        }

        public String getWeight_new() {
            return weight_new;
        }

        public void setWeight_new(String weight_new) {
            this.weight_new = weight_new;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public int getRecommend() {
            return recommend;
        }

        public void setRecommend(int recommend) {
            this.recommend = recommend;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", desc='" + desc + '\'' +
                    ", video_url='" + video_url + '\'' +
                    ", published=" + published +
                    ", weight_new='" + weight_new + '\'' +
                    ", platform='" + platform + '\'' +
                    ", pic_url='" + pic_url + '\'' +
                    ", recommend=" + recommend +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "InfoListBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", api=" + api +
                ", data=" + data.toString() +
                '}';
    }
}
