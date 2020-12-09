package com.example.mymvp.RxJava.Net;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

import com.example.mymvp.Bean.ArticleInfo;
import com.example.mymvp.Bean.BaseBean;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * @author zzh
 * @description:
 * @date :2020/9/17 15:00
 */
public class MyHttps extends ObjectLoader {

    private Context context;

    public MyHttps(Context context) {
        this.context = context;
    }

    private Dialog mDialog;

    //获取验证码
    public Observable<BaseBean<ArticleInfo>> getCodeBeanObservable(){
        mDialog = new ProgressDialog(context);

        mDialog.setTitle("数据获取中。。。");



        return observe(HttpManage.getServer().getCarousel())
                .doOnSubscribe(()->mDialog.show())
                .doOnCompleted(()->mDialog.dismiss())
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mDialog.dismiss();
                    }
                })
                .map(new Func1<BaseBean<ArticleInfo>, BaseBean<ArticleInfo>>() {
                    @Override
                    public BaseBean<ArticleInfo> call(BaseBean<ArticleInfo> dataBean) {
                        mDialog.dismiss();
                        return dataBean;
                    }
                });
    }



}
