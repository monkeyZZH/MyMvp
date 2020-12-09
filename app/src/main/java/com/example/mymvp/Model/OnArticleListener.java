package com.example.mymvp.Model;

import com.example.mymvp.Bean.ArticleInfo;

/**
 * @author zzh
 * @description:
 * @date :2020/12/4 13:49
 */
public interface OnArticleListener {
    void onSuccess(ArticleInfo articleInfo);
    void onStart();
    void onFailed();
    void onFinish();
}
