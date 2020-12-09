package com.example.mymvp.Presenter;

import com.example.mymvp.Bean.ArticleInfo;
import com.example.mymvp.Model.ArticleModel;
import com.example.mymvp.Model.ArticleModelImpl;
import com.example.mymvp.Model.OnArticleListener;
import com.example.mymvp.View.ArticleView;

/**
 * @author zzh
 * @description:
 * @date :2020/12/4 13:50
 */
public class ArticlePresenterImpl implements ArticlePresenter, OnArticleListener {
    private ArticleView mArticleView;
    private ArticleModel mArticleModel;
    public ArticlePresenterImpl(ArticleView mArticleView) {
        this.mArticleView = mArticleView;
        mArticleModel = new ArticleModelImpl();
    }
    @Override
    public void getArticle() {
        mArticleModel.getArtcle(this);
    }
    @Override
    public void onSuccess(ArticleInfo articleInfo) {
        mArticleView.setArticleInfo(articleInfo);
    }
    @Override
    public void onStart() {
        mArticleView.showLoading();
    }
    @Override
    public void onFailed() {
        mArticleView.showError();
    }
    @Override
    public void onFinish() {
        mArticleView.hideLoading();
    }
}