package com.example.a12710.pandachannel.module.panda_live;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a12710.pandachannel.R;
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

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        //Toast.makeText(getActivity(), arguments.getString("vsid")+"", Toast.LENGTH_SHORT).show();
        PandaLivebasePresenter pandaLivebasePresenter = new PandaLivebasePresenter(this, arguments.getString("vsid"), p);
        pandaLivebasePresenter.start();
    }

    @Override
    protected void initView(View view) {
        lookRecycler = (XRecyclerView) view.findViewById(R.id.look_recycler);
        lookRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        commonAdapter = new CommonAdapter<PandaFragmentData.VideoBean>(getActivity(), R.layout.gungunitem,list){
            @Override
            protected void convert(ViewHolder holder, PandaFragmentData.VideoBean videoBean, int position) {
                holder.setText(R.id.gungunRecyclerTitle,videoBean.getT());
                holder.setText(R.id.gungunProvide,videoBean.getPtime());
                holder.setText(R.id.videoTime,videoBean.getLen());
                ImageView imageView = holder.getView(R.id.gungunrecyclerImage);
                Glide.with(getActivity()).load(videoBean.getImg()).into(imageView);
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
        return R.layout.fragment_looktack;
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
