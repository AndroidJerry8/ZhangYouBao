package com.game.lol.zhangyoubao.model;

import java.util.List;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/28 21:05
 * 创建描述：英雄界面，周免英雄信息Bean
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class HeroFreeBean {

    /**
     * currenttitle : 本期周免
     * currentdate : 6/24-7/1
     * currentperiod : [{"id":"47"},{"id":"5"},{"id":"46"},{"id":"87"},{"id":"108"},{"id":"103"},{"id":"8"},{"id":"116"},{"id":"71"},{"id":"115"},{"id":"69"},{"id":"95"},{"id":"35"}]
     * nexttitle : 下期周免
     * nextdate : 7/1-7/8
     * nextperiod : [{"id":"67"},{"id":"48"},{"id":"26"},{"id":"14"},{"id":"37"},{"id":"97"},{"id":"31"},{"id":"129"},{"id":"58"},{"id":"82"},{"id":"69"},{"id":"95"},{"id":"35"}]
     */

    private DataBean data;
    /**
     * data : {"currenttitle":"本期周免","currentdate":"6/24-7/1","currentperiod":[{"id":"47"},{"id":"5"},{"id":"46"},{"id":"87"},{"id":"108"},{"id":"103"},{"id":"8"},{"id":"116"},{"id":"71"},{"id":"115"},{"id":"69"},{"id":"95"},{"id":"35"}],"nexttitle":"下期周免","nextdate":"7/1-7/8","nextperiod":[{"id":"67"},{"id":"48"},{"id":"26"},{"id":"14"},{"id":"37"},{"id":"97"},{"id":"31"},{"id":"129"},{"id":"58"},{"id":"82"},{"id":"69"},{"id":"95"},{"id":"35"}]}
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        private String currenttitle;
        private String currentdate;
        private String nexttitle;
        private String nextdate;
        /**
         * id : 47
         */

        private List<CurrentperiodBean> currentperiod;
        /**
         * id : 67
         */

        private List<NextperiodBean> nextperiod;

        public String getCurrenttitle() {
            return currenttitle;
        }

        public void setCurrenttitle(String currenttitle) {
            this.currenttitle = currenttitle;
        }

        public String getCurrentdate() {
            return currentdate;
        }

        public void setCurrentdate(String currentdate) {
            this.currentdate = currentdate;
        }

        public String getNexttitle() {
            return nexttitle;
        }

        public void setNexttitle(String nexttitle) {
            this.nexttitle = nexttitle;
        }

        public String getNextdate() {
            return nextdate;
        }

        public void setNextdate(String nextdate) {
            this.nextdate = nextdate;
        }

        public List<CurrentperiodBean> getCurrentperiod() {
            return currentperiod;
        }

        public void setCurrentperiod(List<CurrentperiodBean> currentperiod) {
            this.currentperiod = currentperiod;
        }

        public List<NextperiodBean> getNextperiod() {
            return nextperiod;
        }

        public void setNextperiod(List<NextperiodBean> nextperiod) {
            this.nextperiod = nextperiod;
        }

        public static class CurrentperiodBean {
            private String id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class NextperiodBean {
            private String id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
