package com.example.mymvp.View;

/**
 * @author zzh
 * @description:
 * @date :2020/12/4 13:50
 */
public interface ArticleView<T> {
    void setArticleInfo(T t);
    void showLoading();
    void hideLoading();
    void showError();
}
