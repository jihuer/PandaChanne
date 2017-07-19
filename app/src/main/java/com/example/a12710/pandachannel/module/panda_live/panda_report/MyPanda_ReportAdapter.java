package com.example.a12710.pandachannel.module.panda_live.panda_report;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.model.bean.PandaBroadTwoBean;

import java.util.ArrayList;

/**
 * Created by dell on 2017/7/19.
 */

public class MyPanda_ReportAdapter extends RecyclerView.Adapter<MyPanda_ReportAdapter.ViewHolder> {
    private ArrayList<PandaBroadTwoBean.ListBean> listBeen;
    private Context context;

    public MyPanda_ReportAdapter(Context context,ArrayList<PandaBroadTwoBean.ListBean> listBeen){
        this.context = context;
        this.listBeen = listBeen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_panda_report,null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.panda_report_title.setText(listBeen.get(position).getTitle());
        holder.panda_report_time.setText(listBeen.get(position).getVideolength());
        Glide.with(context).load(listBeen.get(position).getPicurl()).into(holder.panda_report_img);

    }


    @Override
    public int getItemCount() {
        return listBeen.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView panda_report_title;
        public TextView panda_report_time;
        public ImageView panda_report_img;
        public ViewHolder(View view){
            super(view);

            panda_report_title = (TextView) view.findViewById(R.id.panda_report_title);
            panda_report_time = (TextView) view.findViewById(R.id.panda_report_time);
            panda_report_img = (ImageView) view.findViewById(R.id.panda_report_img);
        }
    }
}
