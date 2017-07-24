package com.example.a12710.pandachannel.activity.personal_info;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonInfoActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.iv_login)
    ImageView ivLogin;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textt)
    TextView textt;
    @BindView(R.id.hostory)
    RelativeLayout hostory;
    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.textt1)
    TextView textt1;
    @BindView(R.id.shoucang)
    RelativeLayout shoucang;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.textt2)
    TextView textt2;
    @BindView(R.id.set)
    RelativeLayout set;

    @Override
    protected void initView() {

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_person_info;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.iv_login, R.id.tv_login, R.id.hostory, R.id.shoucang, R.id.set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.iv_login:

                break;
            case R.id.tv_login:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.hostory:
                break;
            case R.id.shoucang:
                break;
            case R.id.set:
                Intent intent1 = new Intent(PersonInfoActivity.this,SettingActivity.class);
                startActivity(intent1);

                break;
        }
    }
}
