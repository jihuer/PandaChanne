package com.example.a12710.pandachannel.activity.personal_info;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.activity.loginPresent.LoginContract;
import com.example.a12710.pandachannel.activity.loginPresent.LoginPresent;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.example.a12710.pandachannel.global.MyApp;
import com.example.a12710.pandachannel.model.bean.LoginBean;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.LoginView{


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.login_weixin)
    RadioButton loginWeixin;
    @BindView(R.id.login_QQ)
    RadioButton loginQQ;
    @BindView(R.id.login_weibo)
    RadioButton loginWeibo;
    @BindView(R.id.num)
    EditText num;
    @BindView(R.id.num_x)
    ImageView numX;
    @BindView(R.id.tishi_email)
    TextView tishiEmail;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.pass_x)
    ImageView passX;
    @BindView(R.id.tishi_pass)
    TextView tishiPass;
    @BindView(R.id.forget_pass)
    TextView forgetPass;
    @BindView(R.id.dengl)
    Button dengl;
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void initView() {

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.register, R.id.login_weixin, R.id.login_QQ, R.id.login_weibo, R.id.pass_x, R.id.tishi_pass, R.id.forget_pass, R.id.dengl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.register:

                break;
            case R.id.login_weixin:
                UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.WEIXIN, umAuthListener);

                break;
            case R.id.login_QQ:
                UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.login_weibo:
                UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.SINA, umAuthListener);
                break;
            case R.id.pass_x:
                break;
            case R.id.tishi_pass:
                break;
            case R.id.forget_pass:
                break;
            case R.id.dengl:
               String username = num.getText().toString().trim();
               String psw = pass.getText().toString().trim();
               LoginPresent loginPresent = new LoginPresent(this,username,psw);
               loginPresent.start();
               finish();
                break;
        }
    }

    @Override
    public void setPresenter(LoginContract.LoginPresent loginPresent) {

    }

    @Override
    public void setLogin(LoginBean login) {
        SharedPreferences data = MyApp.mContext.getSharedPreferences("data", Context.MODE_PRIVATE);
        String cookie = data.getString("cookie", "");
        Toast.makeText(this, cookie+"================"+login.toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

}
