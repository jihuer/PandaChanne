package com.example.a12710.pandachannel.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;

public class Panda_Report_InfoActivity extends BaseActivity implements View.OnClickListener {

    private ImageView panda_report_back;
    private WebView panda_report_web;
    private CheckBox panda_report_shoucang;
    private ImageView panda_report_share;

    @Override
    protected void initView() {
        panda_report_back = (ImageView) findViewById(R.id.panda_report_back);
        panda_report_web = (WebView) findViewById(R.id.panda_report_web);
        panda_report_share = (ImageView) findViewById(R.id.panda_report_share);
        panda_report_shoucang = (CheckBox) findViewById(R.id.panda_report_shoucang);

        panda_report_back.setOnClickListener(this);
        panda_report_share.setOnClickListener(this);
        panda_report_shoucang.setOnClickListener(this);

        Intent i = getIntent();
        String url = i.getStringExtra("url");
        panda_report_web.loadUrl(url);
//

        panda_report_web.getSettings().setUseWideViewPort(true);
        panda_report_web.getSettings().setLoadWithOverviewMode(true);
        panda_report_web.getSettings().setSupportZoom(true);


        panda_report_web.getSettings().setJavaScriptEnabled(true);
        panda_report_web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                panda_report_web.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_panda__report__info;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.panda_report_back:
                finish();
                break;
            case R.id.panda_report_shoucang:
                if (panda_report_shoucang.isChecked()){
                    Toast.makeText(Panda_Report_InfoActivity.this,"已添加，请到[我的收藏]中查看",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Panda_Report_InfoActivity.this,"已取消收藏",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id. panda_report_share:
                break;
        }
    }
}
