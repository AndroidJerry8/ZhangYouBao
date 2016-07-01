package com.game.lol.zhangyoubao.service;


import com.game.lol.zhangyoubao.model.CommShowAllBean;
import com.game.lol.zhangyoubao.model.CommShowCommentBean;
import com.game.lol.zhangyoubao.model.InfoTitleBean;

import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * ====================================
 * 作者：王月丽&付明明
 * 版本：1.0
 * 创建日期：2016/6/21 21:05
 * 创建描述：Retrofit请求接口：若需自定义返回类型，只需更改Call<ResponseBody> getJsonStringFromNet 的泛型和方法名
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public interface INetRequestService {
    //http://lol.zhangyoubao.com/ apis/rest/ItemsService/lists?  catid=10178&cattype=news&page=1&i_=y1afSTYuh8nAf0cpSsD/B/5dQYX5eaLUxbZaW4KtEM4=&t_=1466666780240&p_=3065
    String URL_A_R = "apis/rest/";
    /*
     * Retrofit请求接口：若需自定义返回类型，只需更改Call<ResponseBody> getJsonStringFromNet 的泛型和方法名
     */

    @GET(URL_A_R + "{serviceType}/{type}?")
    Call<ResponseBody> getDataFromLOLNet(@Path("serviceType") String serviceType, @Path("type") String type, @QueryMap Map<String, String> params);

    @GET(URL_A_R + "{serviceType}/{type}?")
    Call<InfoTitleBean> getInfoTitleBean(@Path("serviceType") String serviceType, @Path("type") String type, @QueryMap Map<String, String> params);

    @GET(URL_A_R+"{serviceType}/{type}?")
    Call<CommShowAllBean> getCommShowAllBean(@Path("serviceType") String serviceType, @Path("type") String type, @QueryMap Map<String, String> params);

    @GET(URL_A_R+"{serviceType}/{type}?")
    Call<CommShowCommentBean>getCommShowCommentBean(@Path("serviceType") String serviceType, @Path("type") String type, @QueryMap Map<String, String> params);
}
