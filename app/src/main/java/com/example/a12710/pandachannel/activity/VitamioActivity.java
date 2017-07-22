package com.example.a12710.pandachannel.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VitamioActivity extends BaseActivity {


    @BindView(R.id.vitamio)
    VideoView vitamio;

    @Override
    protected void initView() {
        playfunction();
    }

    private void playfunction() {
        Intent intent = getIntent();
        String path = intent.getStringExtra("url");
        Toast.makeText(this, path+"", Toast.LENGTH_SHORT).show();
        if (path == "") {
            Toast.makeText(this, "请填写视频的URL", Toast.LENGTH_LONG).show();
            return;
        }
        vitamio.setVideoURI(Uri.parse(path));
        /*vitamio.setVideoPath(path);*/   //设置视频网络地址
        MediaController controller = new MediaController(this);
        vitamio.setMediaController(controller);
        vitamio.start();

    }


    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_vitamio;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
