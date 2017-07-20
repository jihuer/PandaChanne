package com.example.a12710.pandachannel.module.gungun_video;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a12710.pandachannel.Adapter.RecyclerViewAdapter;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.activity.GungunPlay;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.constants.Urls;
import com.example.a12710.pandachannel.model.bean.RollRollVideoBean;
import com.example.a12710.pandachannel.network.HttpUtils;
import com.example.a12710.pandachannel.network.MyCallBack;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GunGunFragment extends BaseFragment implements GungunContract.gungunlive {
    private GungunContract.gungunlivepresenter gungunlivepresenter;
    private TextView gungunTitle;
    private ImageView image;
    private TextView title;
    private TextView gunguntitle;
    private XRecyclerView xrecycler;
    private View view1;
    private List<RollRollVideoBean.ListBean> list1;
    private RecyclerViewAdapter adapter;

    @Override
    public void setPresenter(GungunContract.gungunlivepresenter gungunlivepresenter) {
        this.gungunlivepresenter = gungunlivepresenter;
    }

    @Override
    protected void initData() {
        gungunlivepresenter = new GungunPresenter(this);
        gungunlivepresenter.start();

        gungunTitle.setText("滚滚视频");
        gungunTitle.setTextColor(Color.WHITE);
        gungunTitle.setTextSize(20);
        final String rollvideo = Urls.ROLLVIDEO;
//        String url = "http://www.ipanda.com/kehuduan/video/index.json";
        Map<String, String> map = new HashMap<>();
        HttpUtils.getInstance().get(rollvideo, map, new MyCallBack<RollRollVideoBean>() {
            @Override
            public void onSuccess(RollRollVideoBean rollRollVideoBean) {
                setResultData(rollRollVideoBean);

            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }

    public void setResultData(RollRollVideoBean rollRollVideoBean) {
        final List<RollRollVideoBean.BigImgBean> list = rollRollVideoBean.getBigImg();
        list1 = rollRollVideoBean.getList();
        Log.e("123465789", list.get(0).getTitle());
        final String title = list.get(0).getTitle();
        final String imageurl = list.get(0).getImage();


        adapter = new RecyclerViewAdapter(getActivity(), list1);
        xrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        xrecycler.setAdapter(adapter);
        adapter.setoClicks(new RecyclerViewAdapter.oClicks() {
            @Override
            public void onclicks(int position) {
                Intent intent = new Intent(getActivity(), GungunPlay.class);
                intent.putExtra("videourl", list1.get(position).getUrl());
                intent.putExtra("title", list1.get(position).getTitle());
                intent.putExtra("image", list1.get(position).getImage());
                intent.putExtra("provide",list1.get(position).getBrief());
                startActivity(intent);
            }
        });
        view1 = LayoutInflater.from(getActivity()).inflate(R.layout.topimageview, null);
        image = (ImageView) view1.findViewById(R.id.gungunvideo_image);
        gunguntitle = (TextView) view1.findViewById(R.id.gungunvideo_title);
        View footView = LayoutInflater.from(getActivity()).inflate(R.layout.listview_footerview, null);
        xrecycler.addHeaderView(view1);
        xrecycler.setFootView(footView);
        Glide.with(getActivity()).load(imageurl).into(image);
        gunguntitle.setText(title);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse( "http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/07/17/3d92fae34dc14b2492de15d5dd122ac8_h264200000nero_aac16.mp4");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Log.v("URI:::::::::", uri.toString());
                intent.setDataAndType(uri, "video/mp4");
                startActivity(intent);
            }
        });

    }


    @Override
    protected void initView(View view) {
        gungunTitle = (TextView) view.findViewById(R.id.toobar2_title);
        xrecycler = (XRecyclerView) view.findViewById(R.id.xrecycler);
        xrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                adapter.notifyDataSetChanged();
                xrecycler.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                    xrecycler.loadMoreComplete();
            }

        });
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_gun_gun;
    }

}
