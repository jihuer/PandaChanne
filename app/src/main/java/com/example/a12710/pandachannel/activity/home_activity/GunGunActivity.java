package com.example.a12710.pandachannel.activity.home_activity;

import android.content.Intent;
import android.net.Uri;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.example.a12710.pandachannel.model.bean.Gun_video;
import com.example.a12710.pandachannel.network.HttpUtils;
import com.example.a12710.pandachannel.network.MyCallBack;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by 魏正洋 on 2017/7/24.
 */

public class GunGunActivity extends BaseActivity {
    @Override
    protected void initView() {
        Intent intent = getIntent();
        String gun = intent.getStringExtra("gun");
        HttpUtils.getInstance().get(gun, null, new MyCallBack<Gun_video>() {

            @Override
            public void onSuccess(Gun_video gun_video) {
                String s = gun_video.getVideo().getChapters().get(0).getUrl();
                VideoView videoview_top = (VideoView) findViewById(R.id.gungun_video);
                videoview_top.setVideoURI(Uri.parse(s));
                MediaController controller = new MediaController(GunGunActivity.this);
                videoview_top.setMediaController(controller);
                videoview_top.setMediaController(controller);
                videoview_top.requestFocus();
                videoview_top.start();   //开始播放
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.video_gungun;
    }
}
