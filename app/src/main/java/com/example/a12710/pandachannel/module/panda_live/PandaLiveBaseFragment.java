package com.example.a12710.pandachannel.module.panda_live;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.activity.personal_info.Panda_image_video_Activity;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.PandaFragmentData;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 12710 on 2017/7/20.
 */

public class PandaLiveBaseFragment extends BaseFragment implements PandaLivebaseContrsct.LivebaseView {
   // @BindView(R.id.look_recycler)
    XRecyclerView lookRecycler;
    Unbinder unbinder;
    private int p = 1;
    private List<PandaFragmentData.VideoBean> list = new ArrayList<>();
    private CommonAdapter commonAdapter;

    private String url = "";
    private String id;

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        //Toast.makeText(getActivity(), arguments.getString("vsid")+"", Toast.LENGTH_SHORT).show();
        id = arguments.getString("vsid");
        PandaLivebasePresenter pandaLivebasePresenter = new PandaLivebasePresenter(this,id, p);
        pandaLivebasePresenter.start();
    }

    @Override
    protected void initView(View view) {
        lookRecycler = (XRecyclerView) view.findViewById(R.id.look_recycler);
        lookRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        commonAdapter = new CommonAdapter<PandaFragmentData.VideoBean>(getActivity(), R.layout.gungunitem,list){
            @Override
            protected void convert(ViewHolder holder, PandaFragmentData.VideoBean videoBean, final int position) {
                holder.setText(R.id.gungunRecyclerTitle,videoBean.getT());
                holder.setText(R.id.gungunProvide,videoBean.getPtime());
                holder.setText(R.id.videoTime,videoBean.getLen());
                ImageView imageView = holder.getView(R.id.gungunrecyclerImage);
                Glide.with(getActivity()).load(videoBean.getImg()).into(imageView);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String substring = list.get(position).getPtime().substring(0, 10).replace("-", "/");
                        if(id.equals("VSET100340574858")){
                            url = "http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/" + substring + "/" + list.get(position).getVid() + "_h264418000nero_aac32-1.mp4";
                        }else if(id.equals("VSET100272959126")){
                                url = "http://cntv.vod.cdn.myqcloud.com/flash/mp4video59/TMS/" + substring + "/" + list.get(position).getVid() + "_h264418000nero_aac32.mp4";}
                            else if(id.equals("VSET100237714751")){
                                    url = "http://vod.cntv.lxdns.com/flash/mp4video60/TMS/" + substring + "/" + list.get(position).getVid() + "_h264418000nero_aac32.mp4";}
                        else if(id.equals("VSET100167308855")){
                                        url = "http://vod.cntv.lxdns.com/flash/mp4video60/TMS/" + substring + "/" + list.get(position).getVid() + "_h264418000nero_aac32-1.mp4";
                                    }else {
                                        url = "http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/" + substring + "/" + list.get(position).getVid() + "_h264418000nero_aac32.mp4";
                                    }
                        Intent intent = new Intent(getActivity(), Panda_image_video_Activity.class);
                        intent.putExtra("url",url);
                        Log.e("url＝＝＝＝＝",url);
                        getActivity().startActivity(intent);

                    }
                });
            }
        };
        lookRecycler.setAdapter(commonAdapter);

        lookRecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                lookRecycler.refresh();
            }

            @Override
            public void onLoadMore() {
                lookRecycler.loadMoreComplete();
                p++;
                initData();
                lookRecycler.refreshComplete();
            }
        });

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override
    public void setPresenter(PandaLivebasePresenter pandaLivebasePresenter) {

    }
    @Override
    public void setPandaFragmentData(PandaFragmentData pandaFragmentData) {
       if (pandaFragmentData!=null){
           list.addAll(pandaFragmentData.getVideo());
           commonAdapter.notifyDataSetChanged();

       }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
