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
import com.example.a12710.pandachannel.model.bean.OriginalBean;

import java.util.ArrayList;

/**
 * Created by 魏正洋 on 2017/7/22.
 */

public class JCAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<OriginalBean.ListBean> alsit;

    public JCAdapter(Context context, ArrayList<OriginalBean.ListBean> alsit) {
        this.context = context;
        this.alsit = alsit;
    }

    @Override
    public int getCount() {
        return alsit.size();
    }

    @Override
    public Object getItem(int position) {
        return alsit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.home_item_amazing_item,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.Home_item_Amazing_image);
            holder.mtext1 = (TextView) convertView.findViewById(R.id.Home_item_Amazing_timeLength);
            holder.mtext2 = (TextView) convertView.findViewById(R.id.Home_item_Amazing_Title);
            holder.mtext3 = (TextView) convertView.findViewById(R.id.Home_item_Amazing_bodytime);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        OriginalBean.ListBean bean = new OriginalBean.ListBean();
        bean = alsit.get(position);
        Glide.with(context).load(bean.getImage()).into(holder.imageView);
        holder.mtext1.setText(bean.getVideoLength().toString());
        holder.mtext2.setText(bean.getTitle().toString());
        holder.mtext3.setText(bean.getDaytime().toString());
        return convertView;
    }
    class ViewHolder{
        private ImageView imageView;
        private TextView mtext1,mtext2,mtext3;
    }
}
