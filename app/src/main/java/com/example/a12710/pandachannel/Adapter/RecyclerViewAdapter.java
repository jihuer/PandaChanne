package com.example.a12710.pandachannel.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.model.bean.RollRollVideoBean;

import java.util.List;

/**
 * Created by 陆向阳 on 2017/7/19.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Viewholder> {
    private Context context;
    private List<RollRollVideoBean.ListBean> list;

    public RecyclerViewAdapter(Context context, List<RollRollVideoBean.ListBean> list) {
        this.context = context;
        this.list = list;
        Log.e("789456123", list.size() + "");
    }

    @Override
    public RecyclerViewAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gungunitem, null);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.Viewholder holder, final int position) {
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT);

        holder.itemView.setLayoutParams(layoutParams);
        holder.time.setText(list.get(position).getVideoLength());
        holder.title.setText(list.get(position).getTitle());
        holder.provide.setText(list.get(position).getBrief());
        if (list.get(position).getImage() != null) {
            Glide.with(context).load(list.get(position).getImage()).into(holder.gungunrecyclerImage);
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
        private final TextView provide;

        public Viewholder(View itemView) {
            super(itemView);
            gungunrecyclerImage = (ImageView) itemView.findViewById(R.id.gungunrecyclerImage);
            time = (TextView) itemView.findViewById(R.id.videoTime);
            title = (TextView) itemView.findViewById(R.id.gungunRecyclerTitle);
            provide = (TextView) itemView.findViewById(R.id.gungunProvide);
        }
    }

    public interface oClicks {
        public void onclicks(int position);
    }
    oClicks oClicks;

    public void setoClicks(RecyclerViewAdapter.oClicks oClicks) {
        this.oClicks = oClicks;
    }
}
