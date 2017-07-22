package com.example.a12710.pandachannel.adpter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.model.bean.LiveChinaContentBean;
import com.example.a12710.pandachannel.view.BaseAdapters;

import java.util.List;

/**
 * Created by ASUS on 2017/7/20.
 */

public class LiveChinaAdapter extends BaseAdapters<LiveChinaContentBean.LiveBean> {
    int s=0;

    public LiveChinaAdapter(Context context, List<LiveChinaContentBean.LiveBean> datas) {
        super(context, R.layout.fragment_livechina_item, datas);
    }

    @Override
    public void convert(final ViewHolder holder, LiveChinaContentBean.LiveBean liveBean) {
        String u = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+liveBean.getId()+"&client=androidapp";

        Log.d("LiveChinaAdapter", u);
        holder.setText(R.id.lc_fi_title, liveBean.getTitle());
        holder.setText(R.id.lc_fi_brief, liveBean.getBrief());


        final ImageView imageView=holder.getView(R.id.lc_fi_image);
        final ImageView jiazai=holder.getView(R.id.lc_fi_jiazai);
        Glide.with(context).load(liveBean.getImage()).asBitmap()
                .thumbnail(0.05f)//降低分辨率
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
        holder.setOnclickListener(R.id.lc_fi_image, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "播放", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
