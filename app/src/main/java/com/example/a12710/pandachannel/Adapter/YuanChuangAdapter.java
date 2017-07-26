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
import com.example.a12710.pandachannel.model.bean.YuanChuangbean;

import java.util.ArrayList;



/**
 * Created by 魏正洋 on 2017/7/24.
 */

public class YuanChuangAdapter extends BaseAdapter {
    private ArrayList<YuanChuangbean.InteractiveBean> alist = new ArrayList<>();
    private Context context;

    public YuanChuangAdapter(ArrayList<YuanChuangbean.InteractiveBean> alist, Context context) {
        this.alist = alist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return alist.size();
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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.yuanchuang_item, null);
            holder = new Holder();
            holder.mimage = (ImageView) convertView.findViewById(R.id.yuanchuang_image);
            holder.mtext = (TextView) convertView.findViewById(R.id.yuanchuang_text);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        YuanChuangbean.InteractiveBean habean = alist.get(position);

        holder.mtext.setText(habean.getTitle());
        Glide.with(context).load(habean.getImage()).into(holder.mimage);
        return convertView;
    }

    static class Holder {
        private TextView mtext;
        private ImageView mimage;
    }
}
