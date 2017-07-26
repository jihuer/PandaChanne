package com.example.a12710.pandachannel.activity.personal_info;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;

import butterknife.OnClick;

public class PersonInfoActivity extends BaseActivity {


    private RelativeLayout shoucang;

    @Override
    protected void initView() {
        shoucang = (RelativeLayout) findViewById(R.id.shoucang);
        shoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(PersonInfoActivity.this,ShouCangActivity.class);
                Log.e("TAGGGGGG","-------------------");
                PersonInfoActivity.this.startActivity(intent2);

            }
        });
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_person_info;
    }


    @OnClick({R.id.back, R.id.iv_login, R.id.tv_login, R.id.hostory, R.id.set})
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
            case R.id.set:
                Intent intent1 = new Intent(PersonInfoActivity.this,SettingActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
