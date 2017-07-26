package com.example.a12710.pandachannel.activity.personal_info.shoucangFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a12710.pandachannel.R;

import java.util.ArrayList;

/**
 * Created by dell on 2017/7/22.
 */

public class MyListAdapter extends BaseAdapter {
    private ArrayList<String> list;
    private Context context;

    public MyListAdapter(Context context,ArrayList<String> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_panda_report,null);
            holder.img = (ImageView) convertView.findViewById(R.id.panda_report_img);
            holder.title = (TextView) convertView.findViewById(R.id.panda_report_title);
            holder.time = (TextView) convertView.findViewById(R.id.panda_report_time);

            convertView.setTag(holder);
        }else {
           holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position)).into(holder.img);
        holder.title.setText(list.get(position));
        holder.time.setText(list.get(position));
        return convertView;
    }

    class ViewHolder{
        private ImageView img;
        private TextView title;
        private TextView time;
    }
}
