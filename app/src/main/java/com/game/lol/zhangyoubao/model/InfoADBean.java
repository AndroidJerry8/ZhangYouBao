package com.game.lol.zhangyoubao.model;

import java.util.List;

/**
 * ====================================
 * 作者：王月丽
 * 版本：1.0
 * 创建日期：2016/6/22 8:26
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class InfoADBean {

    /**
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 67418
     * title : 国服6月21日更新至6.12
     * desc : 国服6月21日更新至6.12
     * goto_target : item
     * goto_param : {"itemid":"67412","title":"国服6月21日更新至6.12","desc":"国服6月21日更新至6.12"}
     * platform : 1
     * pic_ad_url : http://avatar.anzogame.com/pic_v1/lol/news/20160620/picad67418h5767c8fd.jpg
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
        private String goto_target;
        /**
         * itemid : 67412
         * title : 国服6月21日更新至6.12
         * desc : 国服6月21日更新至6.12
         */

        private GotoParamBean goto_param;
        private String platform;
        private String pic_ad_url;

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

        public String getGoto_target() {
            return goto_target;
        }

        public void setGoto_target(String goto_target) {
            this.goto_target = goto_target;
        }

        public GotoParamBean getGoto_param() {
            return goto_param;
        }

        public void setGoto_param(GotoParamBean goto_param) {
            this.goto_param = goto_param;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getPic_ad_url() {
            return pic_ad_url;
        }

        public void setPic_ad_url(String pic_ad_url) {
            this.pic_ad_url = pic_ad_url;
        }

        public static class GotoParamBean {
            private String itemid;
            private String title;
            private String desc;

            public String getItemid() {
                return itemid;
            }

            public void setItemid(String itemid) {
                this.itemid = itemid;
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

            @Override
            public String toString() {
                return "GotoParamBean{" +
                        "itemid='" + itemid + '\'' +
                        ", title='" + title + '\'' +
                        ", desc='" + desc + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", desc='" + desc + '\'' +
                    ", goto_target='" + goto_target + '\'' +
                    ", goto_param=" + goto_param +
                    ", platform='" + platform + '\'' +
                    ", pic_ad_url='" + pic_ad_url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "InfoADBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", api=" + api +
                ", data=" + data.toString() +
                '}';
    }
}
