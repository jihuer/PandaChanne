package com.example.a12710.pandachannel.activity.home_activity;

import android.net.Uri;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.example.a12710.pandachannel.model.bean.China_live;
import com.example.a12710.pandachannel.network.HttpUtils;
import com.example.a12710.pandachannel.network.MyCallBack;
import com.example.a12710.pandachannel.utils.Home_Url;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by 魏正洋 on 2017/7/24.
 */

public class ChinaliveActivity extends BaseActivity {
    @Override
    protected void initView() {
        HttpUtils.getInstance().get(Home_Url.CHINA1, null, new MyCallBack<China_live>() {

            @Override
            public void onSuccess(China_live china_live) {
                String s = china_live.getFlv_url().getFlv1();
                VideoView videoview_top = (VideoView) findViewById(R.id.china_video);
                videoview_top.setVideoURI(Uri.parse(s));
                MediaController controller = new MediaController(ChinaliveActivity.this);
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
        return R.layout.video_china;
    }
}
