package com.example.a12710.pandachannel.activity;

import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import static android.provider.UserDictionary.Words.APP_ID;

public class Panda_Report_InfoActivity extends BaseActivity implements View.OnClickListener {

    private ImageView panda_report_back;
    private WebView panda_report_web;
    private CheckBox panda_report_shoucang;
    private ImageView panda_report_share;
    private PopupWindow popupWindow;
    private WindowManager.LayoutParams lp;
    private UMShareListener shareListener;

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
                final IWXAPI api = WXAPIFactory.createWXAPI(getApplicationContext(), APP_ID, true);
                api.registerApp(APP_ID);

                popupWindow = new PopupWindow();
                View view = LayoutInflater.from(Panda_Report_InfoActivity.this).inflate(R.layout.popwindown, null);
                popupWindow.setContentView(view);
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                View view1 = LayoutInflater.from(Panda_Report_InfoActivity.this).inflate(R.layout.activity_gungun_video_play, null);
                popupWindow.showAtLocation(view1, Gravity.BOTTOM, 0, 0);
                lp = getWindow().getAttributes();
                lp.alpha = 0.7f;
                getWindow().setAttributes(lp);
                popupWindow.isShowing();
                popupWindow.setOutsideTouchable(true);
                view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });
                view1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });
                view.findViewById(R.id.facebook).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Panda_Report_InfoActivity.this, "未安装该程序", Toast.LENGTH_SHORT).show();
                    }
                });
                view.findViewById(R.id.twitter).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Panda_Report_InfoActivity.this, "未安装该程序", Toast.LENGTH_SHORT).show();
                    }
                });
                view.findViewById(R.id.weibo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new ShareAction(Panda_Report_InfoActivity.this)
                                .setPlatform(SHARE_MEDIA.SINA)//传入平台
                                .withText("hello")//分享内容
                                .setCallback(shareListener)//回调监听器
                                .share();
                    }
                });
                view.findViewById(R.id.pengyouquan).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Panda_Report_InfoActivity.this, "未安装该程序", Toast.LENGTH_SHORT).show();
                    }
                });
                view.findViewById(R.id.pengyouquan).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String text = "share our application";
                        WXTextObject textObj = new WXTextObject();
                        textObj.text = text;

                        WXMediaMessage msg = new WXMediaMessage(textObj);
                        msg.mediaObject = textObj;
                        msg.description = text;

                        SendMessageToWX.Req req = new SendMessageToWX.Req();
                        req.transaction = String.valueOf(System.currentTimeMillis());
                        req.message = msg;

                        api.sendReq(req);

                    }
                });
                break;
        }
        //分享开始的回调，可以用来处理等待框，或相关的文字提示
        shareListener = new UMShareListener() {
            @Override
            public void onStart(SHARE_MEDIA platform) {
                //分享开始的回调，可以用来处理等待框，或相关的文字提示
            }

            @Override
            public void onResult(SHARE_MEDIA platform) {
            }

            @Override
            public void onError(SHARE_MEDIA platform, Throwable t) {
            }

            @Override
            public void onCancel(SHARE_MEDIA platform) {
            }
        };
    }
}
