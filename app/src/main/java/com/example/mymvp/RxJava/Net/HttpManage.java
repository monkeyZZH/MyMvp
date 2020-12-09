package com.example.mymvp.RxJava.Net;

import com.example.mymvp.RxJava.Net.MyGson.MvpGsonConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * @author zzh
 * @description:
 * @date :2020/9/17 11:02
 */
public class HttpManage {
    private static HttpService httpService;
    public static String a ;
    private static final int DEFAULT_TIME_OUT = 5;//超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 10;
    public static HttpService getServer(){

        if (httpService==null){
            synchronized (HttpManage.class){
                if (httpService==null){

                    // 创建 OKHttpClient
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间        builder.writeTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);//写操作 超时时间
                    builder.readTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);//读操作超时时间
                    Retrofit retrofit=new Retrofit.Builder()//创建Retrofit的实例
                            .client(builder.build())
                            .baseUrl(ApiConfig.BASE_URL)
                            .addConverterFactory(MvpGsonConverterFactory.create())  //请求结果转换成实体类
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //适配Rxjava
                            .build();
                    httpService=retrofit.create(HttpService.class);          //获得接口的实例

                }
            }
        }
        return httpService;
    }



}

