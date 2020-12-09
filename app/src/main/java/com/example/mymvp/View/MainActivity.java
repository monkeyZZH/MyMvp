package com.example.mymvp.View;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mymvp.Bean.ArticleInfo;
import com.example.mymvp.Presenter.ArticlePresenter;
import com.example.mymvp.Presenter.ArticlePresenterImpl;
import com.example.mymvp.R;

/**
 * @author zzh
 * @description:
 * @date :2020/12/4 10:33
 */
public class MainActivity extends AppCompatActivity implements ArticleView<ArticleInfo> {


    private Dialog mDialog;
    private TextView city;
    private Button bt_ipinfo;
    private ArticlePresenter mArticlePresenter;

//    public static IpInfoFragment newInstance(){
//        return new IpInfoFragment();
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_ipinfo);
        bt_ipinfo = findViewById(R.id.bt_ipinfo);
        city = findViewById(R.id.tv_city);
        mDialog = new ProgressDialog(this);
        mArticlePresenter=new ArticlePresenterImpl(this);
        mDialog.setTitle("数据获取中。。。");

        bt_ipinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // mPresenter.getIpInfo("39.155.184.172");
                mArticlePresenter.getArticle();
            }
        });
    }


    @Override
    public void setArticleInfo(ArticleInfo articleInfo) {
//        if(null!=articleInfo) {
//            List<ArticleInfo.DataBean> list = articleInfo.getData();
//            if(null!=list&&list.size()>1) {
//                city.setText(list.get(1).getPic()+"");
//               // tv_article_content.setText(list.get(1).getMy_abstract());
//            }
//        }
    }

    @Override
    public void showLoading() {
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if(mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(),"网络出错",Toast.LENGTH_SHORT).show();
    }
}
