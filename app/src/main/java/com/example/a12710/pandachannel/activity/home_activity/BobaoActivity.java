package com.example.a12710.pandachannel.activity.home_activity;

import android.net.Uri;
import android.widget.Toast;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.example.a12710.pandachannel.model.bean.Bobao_video;
import com.example.a12710.pandachannel.network.HttpUtils;
import com.example.a12710.pandachannel.network.MyCallBack;
import com.example.a12710.pandachannel.utils.Home_Url;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by 魏正洋 on 2017/7/24.
 */

public class BobaoActivity extends BaseActivity {

    @Override
    protected void initView() {
        HttpUtils.getInstance().get(Home_Url.BOBAOOUT, null, new MyCallBack<Bobao_video>() {
            @Override
            public void onSuccess(Bobao_video bobao_bean) {

                String s =bobao_bean.getVideo().getChapters().get(0).getUrl();
                VideoView videoview_top = (VideoView) findViewById(R.id.bobao_vidio);
                videoview_top.setVideoURI(Uri.parse(s));
                MediaController controller = new MediaController(BobaoActivity.this);
                videoview_top.setMediaController(controller);
                videoview_top.setMediaController(controller);
                videoview_top.requestFocus();
                videoview_top.start();   //开始播放
            }

            @Override
            public void onFaile(String msg) {
                Toast.makeText(BobaoActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.vidio_bobao;
    }
}
