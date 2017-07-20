package com.example.a12710.pandachannel.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.model.bean.GungunPlayrecycler;

import java.util.List;

/**
 * Created by 陆向阳 on 2017/7/20.
 */

public class PlayAdapter extends RecyclerView.Adapter<PlayAdapter.Viewholder> {
    private Context context;
    private List<GungunPlayrecycler.VideoBean> list;

    public PlayAdapter(Context context, List<GungunPlayrecycler.VideoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public PlayAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gungunplayitem, null);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(PlayAdapter.Viewholder holder, final int position) {
        holder.time.setText(list.get(position).getLen());
        holder.title.setText(list.get(position).getT());
        if (list.get(position).getImg() != null) {
            Glide.with(context).load(list.get(position).getImg()).into(holder.gungunrecyclerImage);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oClicks.onclicks(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        private final ImageView gungunrecyclerImage;
        private final TextView time;
        private final TextView title;

        public Viewholder(View itemView) {
            super(itemView);
            gungunrecyclerImage = (ImageView) itemView.findViewById(R.id.gungunplayImage);
            time = (TextView) itemView.findViewById(R.id.play_videoTime);
            title = (TextView) itemView.findViewById(R.id.gungunplayTitle);
        }
    }

    public interface oClicks {
        public void onclicks(int position);
    }

    RecyclerViewAdapter.oClicks oClicks;

    public void setoClicks(RecyclerViewAdapter.oClicks oClicks) {
        this.oClicks = oClicks;
    }
}
