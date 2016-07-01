package com.game.lol.zhangyoubao.model;

import java.util.List;

/**
 * ====================================
 * 作者：王月丽
 * 版本：1.0
 * 创建日期：2016/6/23 8:30
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class InfoTitleBean {

    /**
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 10178
     * name : 最新
     * catword_id : null
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
        private String name;
        private Object catword_id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getCatword_id() {
            return catword_id;
        }

        public void setCatword_id(Object catword_id) {
            this.catword_id = catword_id;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", catword_id=" + catword_id +
                    '}';
        }
    }
}
