package com.example.a12710.pandachannel.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.model.bean.RollRollbean;

import java.util.ArrayList;

/**
 * Created by 魏正洋 on 2017/7/22.
 */

public class GGAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<RollRollbean.ListBean> alist;

    public GGAdapter(Context context, ArrayList<RollRollbean.ListBean> alist) {
        this.context = context;
        this.alist = alist;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return alist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.home_item_rollingvideo_item,null);
            holder = new Holder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.home_item_Rolling_image);
            holder.mtext1 = (TextView) convertView.findViewById(R.id.Home_item_Rolling_time);
            holder.mtext2 = (TextView) convertView.findViewById(R.id.Home_item_Rolling_body);
            holder.mtext3 = (TextView) convertView.findViewById(R.id.Home_item_Rolling_bodytime);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        RollRollbean.ListBean bean = new RollRollbean.ListBean();
        bean = alist.get(position);
        Glide.with(context).load(bean.getImage()).into(holder.imageView);
        holder.mtext1.setText(bean.getVideoLength().toString());
        holder.mtext2.setText(bean.getTitle().toString());
        holder.mtext3.setText(bean.getDaytime().toString());
        return convertView;
    }
    class Holder{
        private ImageView imageView;
        private TextView mtext1,mtext2,mtext3;
    }
}
