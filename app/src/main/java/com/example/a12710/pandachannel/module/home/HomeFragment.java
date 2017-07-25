package com.example.a12710.pandachannel.module.home;

import android.content.Intent;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.a12710.pandachannel.Adapter.HomeAdapter;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.activity.HuDongActivity;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.HomeDataBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.Timer;
import java.util.TimerTask;


/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 14:21
 * 作 者：T
 * 微信：704003376
 */

public class HomeFragment extends BaseFragment implements HomeContract.HomeView {


    private ImageView hudong;

    private XRecyclerView xRecyclerView;
    private HomeAdapter homeAdapter;
    private HomeDataBean homeDataBean;
    //TODO mHomePresenter未初始化
    private HomeContract.HomePresenter mHomePresenter;

    @Override
    public void setPresenter(HomeContract.HomePresenter presenter) {
        mHomePresenter = presenter;
    }


    @Override
    public void setResultData(HomeDataBean bean) {
        //更新UI

    }

    @Override
    protected void initData() {
        //通过P层处理相关业务逻辑
        mHomePresenter = new HomePresenter(this);
        mHomePresenter.start();
    }

    @Override
    protected void initView(View view) {
        xRecyclerView = (XRecyclerView) view.findViewById(R.id.Home_XRecyclerView);
        homeAdapter = new HomeAdapter(getActivity(), homeDataBean);
        xRecyclerView.setAdapter(homeAdapter);
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        sgm.setOrientation(StaggeredGridLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(sgm);
        xRecyclerView.setLoadingMoreEnabled(false);
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                homeAdapter.notifyDataSetChanged();
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        getActivity().runOnUiThread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        xRecyclerView.refreshComplete();
                                    }
                                });
                    }
                }, 1000);

            }

            @Override
            public void onLoadMore() {
            }
        });
        hudong = (ImageView) view.findViewById(R.id.toobar_hudong);
        hudong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HuDongActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.home_fragment;
    }


}
