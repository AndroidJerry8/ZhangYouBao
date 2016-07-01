package com.game.lol.zhangyoubao.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/23 22:12
 * 创建描述：视频界面 条目信息的Bean
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class VideoListBean {

    /**
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 10174
     * name : 娱乐
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

    public static class DataBean implements Parcelable {
        private String id;
        private String name;

        private List<CatwordIdBean> catword_id;

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

        public List<CatwordIdBean> getCatword_id() {
            return catword_id;
        }

        public void setCatword_id(List<CatwordIdBean> catword_id) {
            this.catword_id = catword_id;
        }

        public static class CatwordIdBean implements Parcelable {
            private String id;
            private String name;
            private String desc;
            private String pic;
            private String pic_url;


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

            public String getPic_url() {
                return pic_url;
            }

            public void setPic_url(String pic_url) {
                this.pic_url = pic_url;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.name);
                dest.writeString(this.desc);
                dest.writeString(this.pic);
                dest.writeString(this.pic_url);
            }

            public CatwordIdBean() {
            }

            protected CatwordIdBean(Parcel in) {
                this.id = in.readString();
                this.name = in.readString();
                this.desc = in.readString();
                this.pic = in.readString();
                this.pic_url = in.readString();
            }

            public static final Parcelable.Creator<CatwordIdBean> CREATOR = new Parcelable.Creator<CatwordIdBean>() {
                @Override
                public CatwordIdBean createFromParcel(Parcel source) {
                    return new CatwordIdBean(source);
                }

                @Override
                public CatwordIdBean[] newArray(int size) {
                    return new CatwordIdBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.name);
            dest.writeTypedList(this.catword_id);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.id = in.readString();
            this.name = in.readString();
            this.catword_id = in.createTypedArrayList(CatwordIdBean.CREATOR);
        }

        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }
}
