package com.example.a12710.pandachannel.adpter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.model.bean.LiveChinaContentBean;
import com.example.a12710.pandachannel.model.bean.LiveSLV;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.VideoView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ASUS on 2017/7/25.
 */

public class LiveChinaZhiboItemAdapter extends RecyclerView.Adapter<LiveChinaZhiboItemAdapter.ViewHolder> {
    Context context;
    List<LiveChinaContentBean.LiveBean> list;
    int s = 0;
    OkHttpClient client = new OkHttpClient();
    private LiveSLV slv;
    int a = 0;



    public LiveChinaZhiboItemAdapter(Context context, List<LiveChinaContentBean.LiveBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_livechina_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        String u = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd" + list.get(position).getId() + "&client=androidapp";
        holder.title.setText(list.get(position).getTitle());
        holder.brief.setText(list.get(position).getBrief());
        Glide.with(context).load(list.get(position).getImage()).asBitmap()
                .thumbnail(0.01f)//降低分辨率
                .placeholder(R.drawable._no_img)//未加载是背景图
                .error(R.color.colorAccent)//图片加载错误是背景图
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);
        holder.linview.setVisibility(View.GONE);
        holder.jiazai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (s) {
                    case 1:
                        s = 0;
                        holder.jiazai.setImageResource(R.drawable.live_china_detail_up);
                        holder.linview.setVisibility(View.VISIBLE);
                        break;
                    case 0:
                        s = 1;
                        holder.jiazai.setImageResource(R.drawable.live_china_detail_down);
                        holder.linview.setVisibility(View.GONE);
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
        holder.bo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.videoview_top.stopPlayback();
                notifyItemChanged(holder.getLayoutPosition() - 1);
                Log.d("LiveChinaZhiboItemAdapt", "a:" + a);

                a = position;
//                Log.d("LiveChinaZhiboItemAdapt", "holder.getItemViewType():" + holder.getItemViewType());
//                Log.d("LiveChinaZhiboItemAdapt", "holder.getItemId():" + holder.getItemId());
//                Log.d("LiveChinaZhiboItemAdapt", "holder.getLayoutPosition():" + holder.getLayoutPosition());
//                Log.d("LiveChinaZhiboItemAdapt", "holder.getOldPosition():" + holder.getOldPosition());
//                Log.d("LiveChinaZhiboItemAdapt", "holder.getPosition():" + holder.getPosition());
//                Log.d("LiveChinaZhiboItemAdapt", "holder.getPosition():" + position);
                if (position == holder.getLayoutPosition() - 1) {
//                    notifyDataSetChanged();

                    holder.bo.setVisibility(View.GONE);
                    holder.imageView.setVisibility(View.GONE);

                    Toast.makeText(context, "播放", Toast.LENGTH_SHORT).show();

                    holder.videoview_top.setVideoURI(Uri.parse(slv.getFlv_url().getFlv2()));

                    // videoview_top.setMediaController(controller);
                    holder.videoview_top.setVideoQuality(MediaPlayer.VIDEOQUALITY_LOW);

                   /* controller.setMediaPlayer(vid                                                                                                                                     eoview_top);

                    controller.setVisibility(View.INVISIBLE);

                    videoview_top.setMediaController(controller);*/

                    holder.videoview_top.requestFocus();

                    holder.videoview_top.start();   //开始播放
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, brief;
        ImageView bo;
        ImageView imageView;
        ImageView jiazai;
        VideoView videoview_top;
        LinearLayout linview;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.lc_fi_title);
            brief = (TextView) itemView.findViewById(R.id.lc_fi_brief);
            bo = (ImageView) itemView.findViewById(R.id.lc_fi_bo);
            imageView = (ImageView) itemView.findViewById(R.id.lc_fi_image);
            jiazai = (ImageView) itemView.findViewById(R.id.lc_fi_jiazai);
            videoview_top = (VideoView) itemView.findViewById(R.id.lc_videoview);
            linview = (LinearLayout) itemView.findViewById(R.id.lc_fi_view);
        }
    }

}
