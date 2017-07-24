package com.example.a12710.pandachannel.activity.personal_info;

import android.content.Intent;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.zhy.android.percent.support.PercentRelativeLayout;

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    SwitchCompat accept_box,automatic_box;
    PercentRelativeLayout clear,user_tickling,upgrade,goodreputation, about_pandachannel;
    private TextView laji;
    ImageView set_back;

    @Override
    protected void initView() {
        accept_box = (SwitchCompat) findViewById(R.id.accept_box);
        automatic_box = (SwitchCompat) findViewById(R.id.automatic_box);
        clear = (PercentRelativeLayout) findViewById(R.id.clear);
        user_tickling = (PercentRelativeLayout) findViewById(R.id.user_tickling);
        upgrade = (PercentRelativeLayout) findViewById(R.id.upgrade);
        goodreputation = (PercentRelativeLayout) findViewById(R.id.goodreputation);
        about_pandachannel = (PercentRelativeLayout) findViewById(R.id.about_pandachannel);
        laji = (TextView) findViewById(R.id.laji);
        set_back = (ImageView) findViewById(R.id.set_back);
        initData();
        inictListener();
    }

    private void initData() {

    }

    private void inictListener() {
        clear.setOnClickListener(this);
        user_tickling.setOnClickListener(this);
        upgrade.setOnClickListener(this);
        goodreputation.setOnClickListener(this);
        about_pandachannel.setOnClickListener(this);
        set_back.setOnClickListener(this);
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clear:
                laji.setText("0.00MB");

                break;
            case R.id.user_tickling:
                Intent intent1 = new Intent(SettingActivity.this, SettingTicklingActivity.class);
                startActivity(intent1);

                break;
            case R.id.upgrade:
                Toast.makeText(this, "已经是最新版本了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.goodreputation:
                break;
            case R.id.about_pandachannel:
                Intent intent = new Intent(SettingActivity.this, SettingAboutActivity.class);
                startActivity(intent);
                break;
            case R.id.set_back:
                finish();
                break;
        }
    }
}
