package com.example.a12710.pandachannel.module.live_china;

import com.example.a12710.pandachannel.model.PandaChannelModelImp;
import com.example.a12710.pandachannel.model.bean.LiveChinaBean;
import com.example.a12710.pandachannel.network.MyCallBack;

/**
 * Created by ASUS on 2017/7/19.
 */

public class LiveChinaPresenter implements LiveChinaContract.LiveChinaPresenter {
    LiveChinaContract.LiveChinaView mliveChinaView;
    PandaChannelModelImp mPandaChannelModelImp;

    public LiveChinaPresenter(LiveChinaContract.LiveChinaView liveChinaView) {
        this.mliveChinaView = liveChinaView;
        mPandaChannelModelImp = new PandaChannelModelImp();
        //实例化PandaLiveContract中的Presenter的
        mliveChinaView.setPresenter(this);
    }

    @Override
    public void start() {
        mPandaChannelModelImp.getLiveData(new MyCallBack<LiveChinaBean>() {
            @Override
            public void onSuccess(LiveChinaBean liveChinaBean) {
                mliveChinaView.setResultData(liveChinaBean);

            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
