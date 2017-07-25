package com.example.a12710.pandachannel.activity.home_activity;

import android.content.Intent;
import android.util.Log;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.example.a12710.pandachannel.model.bean.Lunbo_video;
import com.example.a12710.pandachannel.network.HttpUtils;
import com.example.a12710.pandachannel.network.MyCallBack;

import io.vov.vitamio.widget.VideoView;

/**
 * Created by 魏正洋 on 2017/7/24.
 */

public class LunboActivity extends BaseActivity {
    private VideoView videoView;
    private String lunbo;

    @Override
    protected void initView() {
        Intent intent = getIntent();
        lunbo = intent.getStringExtra("lunbo");
        HttpUtils.getInstance().get(lunbo, null, new MyCallBack<Lunbo_video>() {

            @Override
            public void onSuccess(Lunbo_video lunbo_video) {
                VideoView videoview_top = (VideoView) findViewById(R.id.xiuchang_video);
                String s =lunbo_video.getVideo().getChapters().get(0).getUrl();
                Log.e("TAG", s);
                videoview_top.setVideoPath(s);
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
        return R.layout.vidio_vp;
    }
}
