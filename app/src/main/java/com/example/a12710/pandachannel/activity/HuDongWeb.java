package com.example.a12710.pandachannel.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;

/**
 * Created by 魏正洋 on 2017/7/24.
 */

public class  HuDongWeb extends BaseActivity {
    private ImageView mback,mfenxiang;
    private WebView mweb;
    private TextView mtext;


    @Override
    protected void initView() {
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        String haha = intent.getStringExtra("haha");
        mback = (ImageView) findViewById(R.id.yuanchuang_web_back);
        mfenxiang = (ImageView) findViewById(R.id.yuanchuang_web_fenxiang);
        mweb = (WebView) findViewById(R.id.yuanchaung_web_web);
        mtext = (TextView) findViewById(R.id.yuanchuang_web_title);
        mtext.setText(haha);
        mback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mweb.loadUrl(data);
        mweb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });


    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.yuanchuang_web;
    }
}
