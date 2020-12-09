package com.example.mymvp.Model;

import com.example.mymvp.Bean.ArticleInfo;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;

/**
 * @author zzh
 * @description:
 * @date :2020/12/4 13:49
 */
public class ArticleModelImpl implements ArticleModel {
    @Override
    public void getArtcle(final OnArticleListener onArticleListener) {
        HttpRequest.get("https://api.xidinglan.com/api/home/getCarousel",new BaseHttpRequestCallback<ArticleInfo>(){
            @Override
            protected void onSuccess(ArticleInfo articleInfo) {
                super.onStart();
                onArticleListener.onSuccess(articleInfo);
            }
            @Override
            public void onStart() {
                super.onStart();
                onArticleListener.onStart();
            }
            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                onArticleListener.onFailed();
            }
            @Override
            public void onFinish() {
                super.onFinish();
                onArticleListener.onFinish();
            }

        });

    }
}