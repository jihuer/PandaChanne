package com.example.a12710.pandachannel.activity.personal_info;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.zhy.android.percent.support.PercentLinearLayout;
import com.zhy.android.percent.support.PercentRelativeLayout;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class Panda_image_video_Activity extends BaseActivity {

    private VideoView videoview_top;
    private PercentLinearLayout down;
    private PercentRelativeLayout top;
    private ImageView image_fanhui;
    private TextView tv_title;
    private ImageView image_shouchang;
    private ImageView image_fenxiang;
    private ImageView image_startAndstop;
    private TextView tv_timer;
    private ProgressBar progressBar_jindu;
    private TextView tv_timers;
    private Button btn_fenbianlv;
    private ImageView image_yinLiang;
    private ProgressBar progressBar_yinliang;
    private Animation top_animation_end;
    private Animation down_animation_start;
    private Animation down_animation_end;
    private boolean state = true;
    private Animation top_animation_start;

    @Override
    protected void initView() {

        top = (PercentRelativeLayout) findViewById(R.id.top);

        down = (PercentLinearLayout) findViewById(R.id.down);

        image_fanhui = (ImageView) findViewById(R.id.image_fanhui);
        tv_title = (TextView) findViewById(R.id.tv_broadtop_title);
        image_shouchang = (ImageView) findViewById(R.id.image_broadtop_shouchang);
        image_fenxiang = (ImageView) findViewById(R.id.image_broadtop_fenxiang);
        image_startAndstop = (ImageView) findViewById(R.id.image_broadtop_startAndstop);
        tv_timer = (TextView) findViewById(R.id.tv_timerplayer_timer);
        progressBar_jindu = (ProgressBar) findViewById(R.id.progredd_player_jindu);
        tv_timers = (TextView) findViewById(R.id.tv_player_timers);
        btn_fenbianlv = (Button) findViewById(R.id.btn_player_fenbianlv);
        image_yinLiang = (ImageView) findViewById(R.id.image_player_yinliang);
        progressBar_yinliang = (ProgressBar) findViewById(R.id.progress_player_yinliang);


        //点击播放And暂停
        image_startAndstop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (videoview_top.isPlaying()){

                            videoview_top.pause();

                            image_startAndstop.setImageResource(R.drawable.pla_continue);

                        }else {

                            image_startAndstop.setImageResource(R.drawable.pla_pause);

                            videoview_top.start();

                        }
                    }
                });

        String s = "http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/07/20/429732b855b24e95ad208807174eb85c_h2641200000nero_aac16-1.mp4";

        videoview_top = (VideoView) findViewById(R.id.videoview_sss);
//        videoview_top.setVideoURI(Uri.parse("http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/07/17/3d92fae34dc14b2492de15d5dd122ac8_h264200000nero_aac16.mp4"));

//        videoview_top.setBackgroundResource(R.drawable._no_img);

        videoview_top.setVideoURI(Uri.parse(s));

        MediaController controller = new MediaController(this);

        videoview_top.setMediaController(controller);

        controller.setMediaPlayer(videoview_top);

        controller.setVisibility(View.INVISIBLE);

        videoview_top.setMediaController(controller);

        videoview_top.requestFocus();

        videoview_top.start();   //开始播放

        top_animation_start = AnimationUtils.loadAnimation(this, R.anim.top_translate_start);

        top_animation_start.setDuration(500);

        top_animation_start.setFillAfter(true);

        top_animation_end = AnimationUtils.loadAnimation(this, R.anim.top_translate_end);

        top_animation_end.setDuration(500);

        top_animation_end.setFillAfter(true);

        down_animation_start = AnimationUtils.loadAnimation(this, R.anim.down_translate_start);

        down_animation_start.setDuration(500);

        down_animation_start.setFillAfter(true);

        down_animation_end = AnimationUtils.loadAnimation(this, R.anim.down_translate_end);

        down_animation_end.setDuration(500);

        down_animation_end.setFillAfter(true);

    }


    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_panda_image_video_;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:

                if (state){

                    top.startAnimation(top_animation_start);

                    down.startAnimation(down_animation_start);
                    state = false;
                }else {
                    top.startAnimation(top_animation_end);
                    down.startAnimation(down_animation_end);
                    state = true;
                }
                break;
        }
        return true;
    }
}
