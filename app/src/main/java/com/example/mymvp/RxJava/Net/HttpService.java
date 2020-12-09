package com.example.mymvp.RxJava.Net;


import com.example.mymvp.Bean.ArticleInfo;
import com.example.mymvp.Bean.BaseBean;

import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by kd on 2018/6/13.
 */

public interface HttpService {

    @POST("/demo/store/getStoreById/30")
    Observable<BaseBean<ArticleInfo>> getCarousel();

}