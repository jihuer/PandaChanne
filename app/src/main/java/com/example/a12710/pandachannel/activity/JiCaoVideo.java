package com.example.a12710.pandachannel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.a12710.pandachannel.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class JiCaoVideo extends AppCompatActivity {

    private JCVideoPlayerStandard jiecao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ji_cao_video);

        jiecao = (JCVideoPlayerStandard) findViewById(R.id.jicaovideo);
        Intent intent=getIntent();
        final String url = intent.getStringExtra("url");
        jiecao.setUp(url,JCVideoPlayer.SCREEN_WINDOW_FULLSCREEN,"简单点");
    }
}
