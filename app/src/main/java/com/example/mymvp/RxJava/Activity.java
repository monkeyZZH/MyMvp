package com.example.mymvp.RxJava;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mymvp.Bean.ArticleInfo;
import com.example.mymvp.Bean.BaseBean;
import com.example.mymvp.R;
import com.example.mymvp.RxJava.Net.MyHttps;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * @author zzh
 * @description:
 * @date :2020/12/4 14:57
 */
public class Activity extends AppCompatActivity {

    @BindView(R.id.bt_ipinfo)
    Button btIpinfo;
    @BindView(R.id.tv_city)
    TextView tvCity;
    private Dialog mDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_ipinfo);
        ButterKnife.bind(this);
        mDialog = new ProgressDialog(this);
        mDialog.setTitle("数据获取中。。。");
        btIpinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyHttps(Activity.this).getCodeBeanObservable()
                        .subscribe(new Subscriber<BaseBean<ArticleInfo>>() {
                            @Override
                            public void onCompleted() {
                                Log.e("结果onCompleted","=======");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("结果Throwable",e.getMessage().toString());
                            }

                            @Override
                            public void onNext(BaseBean<ArticleInfo> listBaseBean) {
                                Log.e("结果onNext",listBaseBean.getCode()+"");
                                Log.e("结果onNext",listBaseBean.getMessage());
                                Log.e("结果onNext",listBaseBean.getData().getStoreEntity().getCity()+"");
                            }
                        });

            }
        });


    }



}
