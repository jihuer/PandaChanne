package com.example.a12710.pandachannel.activity.personal_info;

import android.view.View;
import android.widget.ImageView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;

/**
 * Created by ASUS on 2017/7/24.
 */

public class SettingAboutActivity extends BaseActivity {
    ImageView imageView;
    @Override
    protected void initView() {
        imageView = (ImageView) findViewById(R.id.about_fanhui);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_setting_about;
    }
}
