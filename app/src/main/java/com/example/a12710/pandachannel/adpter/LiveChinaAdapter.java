package com.example.a12710.pandachannel.adpter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.model.bean.LiveChinaContentBean;
import com.example.a12710.pandachannel.model.bean.LiveSLV;
import com.example.a12710.pandachannel.view.BaseAdapters;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ASUS on 2017/7/20.
 */

public class LiveChinaAdapter extends BaseAdapters<LiveChinaContentBean.LiveBean> {
    int s=0;
    OkHttpClient client = new OkHttpClient();
    private LiveSLV slv;
    private VideoView videoview_top;

    public LiveChinaAdapter(Context context, List<LiveChinaContentBean.LiveBean> datas) {
        super(context, R.layout.fragment_livechina_item, datas);
    }
    @Override
    public void convert(final ViewHolder holder, LiveChinaContentBean.LiveBean liveBean) {
        String u = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+liveBean.getId()+"&client=androidapp";

        Log.d("LiveChinaAdapter", u);
        holder.setText(R.id.lc_fi_title, liveBean.getTitle());
        holder.setText(R.id.lc_fi_brief, liveBean.getBrief());

        videoview_top = holder.getView(R.id.lc_videoview);
        final ImageView bo = holder.getView(R.id.lc_fi_bo);
        final ImageView imageView=holder.getView(R.id.lc_fi_image);
        final ImageView jiazai=holder.getView(R.id.lc_fi_jiazai);
        Glide.with(context).load(liveBean.getImage()).asBitmap()
                .thumbnail(0.01f)//降低分辨率
                .placeholder(R.drawable._no_img)//未加载是背景图
                .error(R.color.colorAccent)//图片加载错误是背景图
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);

        holder.setViewVisiable(R.id.lc_fi_view, View.GONE);

        holder.setOnclickListener(R.id.lc_fi_jiazai, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (s) {
                    case 1:
                        s = 0;
                        jiazai.setImageResource(R.drawable.live_china_detail_up);
                        holder.setViewVisiable(R.id.lc_fi_view, View.VISIBLE);
                        break;

                    case 0:
                        s = 1;
                        jiazai.setImageResource(R.drawable.live_china_detail_down);
                        holder.setViewVisiable(R.id.lc_fi_view, View.GONE);
                        break;
                }
            }
        });

        final Request request = new Request.Builder().url(u).build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Gson gson = new Gson();
                slv = gson.fromJson(s, LiveSLV.class);

            }
        });
        final MediaPlayer mediaPlayer = new MediaPlayer(context);
        holder.setOnclickListener(R.id.lc_fi_image, new View.OnClickListener() {

          //  private MediaController controller = new MediaController(context);


            @Override
            public void onClick(View v) {

//                    imageView.setVisibility(View.GONE);
//                    bo.setVisibility(View.GONE);
                    videoview_top.stopPlayback();
                    mediaPlayer.release();

                    Toast.makeText(context, "播放", Toast.LENGTH_SHORT).show();

                    videoview_top.setVideoURI(Uri.parse(slv.getFlv_url().getFlv2()));

                   // videoview_top.setMediaController(controller);
                    videoview_top.setVideoQuality(MediaPlayer.VIDEOQUALITY_LOW);

                   /* controller.setMediaPlayer(videoview_top);

                    controller.setVisibility(View.INVISIBLE);

                    videoview_top.setMediaController(controller);*/

                    videoview_top.requestFocus();

                    videoview_top.start();   //开始播放


            }
        });


    }

}
