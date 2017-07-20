package com.example.a12710.pandachannel.module.live_china;

import com.example.a12710.pandachannel.model.PandaChannelModelImp;
import com.example.a12710.pandachannel.model.bean.LiveChinaBean;
import com.example.a12710.pandachannel.model.bean.LiveChinaContentBean;
import com.example.a12710.pandachannel.module.live_china.live_china_content.LiveChinaContract;
import com.example.a12710.pandachannel.network.MyCallBack;

/**
 * Created by ASUS on 2017/7/19.
 */

public class LiveChinaTabPresenter implements LiveChinaTabContract.LiveChinaTabPresenter {
    LiveChinaTabContract.LiveChinaTabView mliveChinaTabView;
    PandaChannelModelImp mPandaChannelModelImp;

    public LiveChinaTabPresenter(LiveChinaTabContract.LiveChinaTabView liveChinaTabView) {
        this.mliveChinaTabView = liveChinaTabView;
        mPandaChannelModelImp = new PandaChannelModelImp();
        //实例化PandaLiveContract中的Presenter的
        mliveChinaTabView.setPresenter(this);
    }

    @Override
    public void start() {
        mPandaChannelModelImp.getLiveTabData(new MyCallBack<LiveChinaBean>() {
            @Override
            public void onSuccess(LiveChinaBean liveChinaBean) {
                mliveChinaTabView.setResultData(liveChinaBean);

            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
