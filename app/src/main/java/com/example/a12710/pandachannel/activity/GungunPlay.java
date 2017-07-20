package com.example.a12710.pandachannel.activity;

import android.support.v7.app.AppCompatActivity;

public class GungunPlay extends AppCompatActivity {

  /*  private TextView playtitle;
    private MediaController mediaController;
    private ImageButton jieshaoimage;
    private LinearLayout jieshaoxiangqing;
    private boolean a = true;
    private ImageButton collectimg;
    private ImageButton share;
    private XRecyclerView gungunplay_xrecycler;
    private io.vov.vitamio.widget.VideoView videoview;
    private MediaController mMediaController;
    private JCVideoPlayer jiecao;
    private boolean b = true;
    private PlayAdapter adapter;
    private int i = 0;
    private TextView gungunplayjieshao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this))
            return;
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
        jiecao = (JCVideoPlayer) findViewById(R.id.jiecao);
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

        Glide.with(this).load(image).into(jiecao.ivThumb);
        jiecao.setUp(url, title);
        String ur = "http://api.cntv.cn/video/videolistById?n=10&vsid=VSET100284428835&p=1&serviceId=panda&em=0";
        Map<String, String> map = new HashMap<>();
        HttpUtils.getInstance().get(ur, map, new MyCallBack<GungunPlayrecycler>() {
            @Override
            public void onSuccess(GungunPlayrecycler gungunPlayrecycler) {
                final List<GungunPlayrecycler.VideoBean> video = gungunPlayrecycler.getVideo();
                Log.e("741258963", video.size() + "");
                adapter = new PlayAdapter(GungunPlay.this, video);
                gungunplay_xrecycler.setLayoutManager(new LinearLayoutManager(GungunPlay.this));
                gungunplay_xrecycler.setAdapter(adapter);
                adapter.setoClicks(new RecyclerViewAdapter.oClicks() {
                    @Override
                    public void onclicks(int position) {
                        final String videourl = video.get(position).getUrl();
                        final String vid = video.get(position).getVid();
                        Log.e("abcdefghi", vid);
                        Glide.with(GungunPlay.this).load(video.get(position).getImg()).into(jiecao.ivThumb);
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
        collectimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a) {
                    collectimg.setImageResource(R.drawable.collect_yes);
                    a = false;
                    Log.e("TAG-------", a + "");
                } else {
                    collectimg.setImageResource(R.drawable.collect_no);
                    a = true;
                    Log.e("TAG-----------", a + "");
                }
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }*/
}
