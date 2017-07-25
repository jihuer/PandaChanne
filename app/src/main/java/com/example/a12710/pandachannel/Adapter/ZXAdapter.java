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
import com.example.a12710.pandachannel.model.bean.HomeDataBean;

import java.util.ArrayList;

/**
 * Created by 魏正洋 on 2017/7/22.
 */

public class ZXAdapter extends BaseAdapter {
    private Context mcontext;
    private ArrayList<HomeDataBean.DataBean.PandaliveBean.ListBean> alist;

    public ZXAdapter(Context mcontext, ArrayList<HomeDataBean.DataBean.PandaliveBean.ListBean> alist) {
        this.mcontext = mcontext;
        this.alist = alist;
    }

    @Override
    public int getCount() {
        return 9;
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
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.home_item_live_item,null);
            holder.imageView = (ImageView) convertView.findViewById(R.id.Home_item_liveshow_Image);
            holder.mtext = (TextView) convertView.findViewById(R.id.Home_item_liveshow_body);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        HomeDataBean.DataBean.PandaliveBean.ListBean bean = new HomeDataBean.DataBean.PandaliveBean.ListBean();
        bean = alist.get(position);
        holder.mtext.setText(bean.getTitle());
        Glide.with(mcontext).load(bean.getImage()).into(holder.imageView);
        return convertView;
    }
    class ViewHolder{
        private ImageView imageView;
        private TextView mtext;
    }
}
