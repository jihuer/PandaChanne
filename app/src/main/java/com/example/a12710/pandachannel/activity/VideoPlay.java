package com.example.a12710.pandachannel.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a12710.pandachannel.Adapter.PlayAdapter;
import com.example.a12710.pandachannel.Adapter.RecyclerViewAdapter;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.model.bean.GungunPlayrecycler;
import com.example.a12710.pandachannel.network.HttpUtils;
import com.example.a12710.pandachannel.network.MyCallBack;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoPlay extends AppCompatActivity {

    private TextView playtitle;
    private MediaController mediaController;
    private ImageButton jieshaoimage;
    private LinearLayout jieshaoxiangqing;

    private ImageButton collectimg;
    private ImageButton share;
    private XRecyclerView gungunplay_xrecycler;
    private PlayAdapter adapter;
    private boolean a = true;
    private TextView gungunplayjieshao;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    private boolean aa;
    private UMShareListener shareListener;
    private PopupWindow popupWindow;
    private WindowManager.LayoutParams lp;
    private final String APP_ID = "wxbd8d9e9f2e348364";
    private String videourl;
    private String videourl1;
    private String img;
    private JCVideoPlayerStandard jiecao;
    private long i=0;

    public VideoPlay() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gungun_video_play);
        initView();
        initData();
    }

    private void initView() {
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        gungunplayjieshao = (TextView) findViewById(R.id.gungunplay_jieshao);
        playtitle = (TextView) findViewById(R.id.playTitle);
        jiecao = (JCVideoPlayerStandard) findViewById(R.id.jiecao);
        jieshaoimage = (ImageButton) findViewById(R.id.jieshao);
        jieshaoxiangqing = (LinearLayout) findViewById(R.id.jieshaoxiangqing);
        collectimg = (ImageButton) findViewById(R.id.collect);
        share = (ImageButton) findViewById(R.id.share);
        gungunplay_xrecycler = (XRecyclerView) findViewById(R.id.gungunplay_xrecycler);

        gungunplay_xrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                adapter.notifyDataSetChanged();
                gungunplay_xrecycler.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                initData();
                i++;
                gungunplay_xrecycler.loadMoreComplete();
            }
        });
    }

    private void initData() {
        Intent intent = getIntent();
        final String videourl = intent.getStringExtra("videourl");
        final String title = intent.getStringExtra("title");
        final String image = intent.getStringExtra("image");
        final String pid = intent.getStringExtra("pid");
        final String url = intent.getStringExtra("url");
        final String brief = intent.getStringExtra("provide");
        gungunplayjieshao.setText(brief);
        playtitle.setText(title);
        Glide.with(this).load(image).into(jiecao.thumbImageView);
//        jiecao.setUp(url, title);
        String ur = "http://api.cntv.cn/video/videolistById?n=10&vsid=VSET100284428835&p=1&serviceId=panda&em="+i;
        Map<String, String> map = new HashMap<>();
        HttpUtils.getInstance().get(ur, map, new MyCallBack<GungunPlayrecycler>() {
            @Override
            public void onSuccess(GungunPlayrecycler gungunPlayrecycler) {
                final List<GungunPlayrecycler.VideoBean> video = gungunPlayrecycler.getVideo();
                Log.e("741258963", video.size() + "");
                adapter = new PlayAdapter(VideoPlay.this, video);
                gungunplay_xrecycler.setLayoutManager(new LinearLayoutManager(VideoPlay.this));
                gungunplay_xrecycler.setAdapter(adapter);
                adapter.setoClicks(new RecyclerViewAdapter.oClicks() {
                    @Override
                    public void onclicks(int position) {
                        videourl1 = video.get(position).getUrl();
                        final String vid = video.get(position).getVid();
                        Log.e("abcdefghi", vid);
                        img = video.get(position).getImg();
                        Glide.with(VideoPlay.this).load(video.get(position).getImg()).into(jiecao.thumbImageView);
                        gungunplayjieshao.setText(video.get(position).getT());
                    }
                });

            }

            @Override
            public void onFaile(String msg) {

            }
        });

        jieshaoimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a) {
                    jieshaoimage.setImageResource(R.drawable.lpanda_show);
                    jieshaoxiangqing.setVisibility(View.VISIBLE);
                    a = false;
                    Log.e("TAG-------", a + "");
                } else {
                    jieshaoimage.setImageResource(R.drawable.lpanda_off);
                    jieshaoxiangqing.setVisibility(View.GONE);
                    a = true;
                    Log.e("TAG-----------", a + "");
                }
            }
        });
        sharedPreferences = getSharedPreferences("state", MODE_PRIVATE);
        edit = sharedPreferences.edit();
        edit.putBoolean("a", true);
        edit.commit();
        collectimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aa = sharedPreferences.getBoolean("a", false);
                Log.e("123456798", aa + "");
                if (aa) {
                    collectimg.setImageResource(R.drawable.collect_yes);
                    edit.putBoolean("a", false);
                    edit.commit();
                    Log.e("TAG-------", aa + "");
                } else {
                    collectimg.setImageResource(R.drawable.collect_no);
                    edit.putBoolean("a", true);
                    edit.commit();
                    Log.e("TAG-----------", aa + "");
                }
            }
        });
        final IWXAPI api = WXAPIFactory.createWXAPI(getApplicationContext(), APP_ID, true);
        api.registerApp(APP_ID);
        share.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                popupWindow = new PopupWindow();
                View view = LayoutInflater.from(VideoPlay.this).inflate(R.layout.popwindown, null);
                popupWindow.setContentView(view);
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                View view1 = LayoutInflater.from(VideoPlay.this).inflate(R.layout.activity_gungun_video_play, null);
                popupWindow.showAtLocation(view1, Gravity.BOTTOM, 0, 0);
                lp = getWindow().getAttributes();
                lp.alpha = 0.7f;
                getWindow().setAttributes(lp);
                popupWindow.isShowing();
                popupWindow.setOutsideTouchable(true);
                view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });
                view1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });
                view.findViewById(R.id.facebook).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(VideoPlay.this, "未安装该程序", Toast.LENGTH_SHORT).show();
                    }
                });
                view.findViewById(R.id.twitter).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(VideoPlay.this, "未安装该程序", Toast.LENGTH_SHORT).show();
                    }
                });
                view.findViewById(R.id.weibo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new ShareAction(VideoPlay.this)
                                .setPlatform(SHARE_MEDIA.QQ)//传入平台
                                .withText("hello")//分享内容
                                .setCallback(shareListener)//回调监听器
                                .share();
                    }
                });
                view.findViewById(R.id.pengyouquan).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(VideoPlay.this, "未安装该程序", Toast.LENGTH_SHORT).show();
                    }
                });
                view.findViewById(R.id.pengyouquan).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String text = "share our application";
                        WXTextObject textObj = new WXTextObject();
                        textObj.text = text;

                        WXMediaMessage msg = new WXMediaMessage(textObj);
                        msg.mediaObject = textObj;
                        msg.description = text;

                        SendMessageToWX.Req req = new SendMessageToWX.Req();
                        req.transaction = String.valueOf(System.currentTimeMillis());
                        req.message = msg;

                        api.sendReq(req);

                    }
                });
            }
        });
        //分享开始的回调，可以用来处理等待框，或相关的文字提示
        shareListener = new UMShareListener() {
            @Override
            public void onStart(SHARE_MEDIA platform) {
                //分享开始的回调，可以用来处理等待框，或相关的文字提示
            }

            @Override
            public void onResult(SHARE_MEDIA platform) {
            }

            @Override
            public void onError(SHARE_MEDIA platform, Throwable t) {
            }

            @Override
            public void onCancel(SHARE_MEDIA platform) {
            }
        };
    }

}
