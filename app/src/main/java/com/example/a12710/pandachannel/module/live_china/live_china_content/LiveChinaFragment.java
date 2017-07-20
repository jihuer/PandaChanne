package com.example.a12710.pandachannel.module.live_china.live_china_content;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.adpter.LiveChinaAdapter;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.LiveChinaBean;
import com.example.a12710.pandachannel.model.bean.LiveChinaContentBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/7/19.
 */

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.LiveChinaView {
    LiveChinaContract.LiveChinaPresenter mLiveChinaPresenter;
    String url;
    XRecyclerView mXRecyclerView;
    LiveChinaAdapter adapter;


    public LiveChinaFragment(String url) {
        this.url = url;
    }



    @Override
    public void setPresenter(LiveChinaContract.LiveChinaPresenter liveChinaPresenter) {
        this.mLiveChinaPresenter = liveChinaPresenter;
    }

    @Override
    protected void initData() {
        mLiveChinaPresenter = new LiveChinaPresenter(url,this);
        mLiveChinaPresenter.start();

    }

    @Override
    protected void initView(View view) {
        mXRecyclerView = (XRecyclerView) view.findViewById(R.id.lc_rv);
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_livechina_fragment;
    }





    @Override
    public void setResultData(LiveChinaContentBean liveChinaContentBean) {
        final List<LiveChinaContentBean.LiveBean> been = new ArrayList<>();
        been.addAll(liveChinaContentBean.getLive());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mXRecyclerView.setLayoutManager(layoutManager);
        mXRecyclerView.setLoadingMoreEnabled(false);
        mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //refresh data here刷新
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        been.clear();
                        mLiveChinaPresenter.start();
                        adapter.notifyDataSetChanged();
                        mXRecyclerView.refreshComplete();
                    }

                }, 2500);
            }

            @Override
            public void onLoadMore() {
                // load more data here加载
                mXRecyclerView.loadMoreComplete();
            }
        });
        adapter = new LiveChinaAdapter(getContext(),been);
        mXRecyclerView.setAdapter(adapter);
    }

}
