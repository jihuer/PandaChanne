package com.example.a12710.pandachannel.module.live_china.live_china_content;

import com.example.a12710.pandachannel.model.PandaChannelModelImp;
import com.example.a12710.pandachannel.model.bean.LiveChinaContentBean;
import com.example.a12710.pandachannel.network.MyCallBack;

/**
 * Created by ASUS on 2017/7/19.
 */

public class LiveChinaPresenter implements LiveChinaContract.LiveChinaPresenter {
    LiveChinaContract.LiveChinaView mliveChinaView;
    PandaChannelModelImp mPandaChannelModelImp;
    String mUrl;

    public LiveChinaPresenter(String url,LiveChinaContract.LiveChinaView liveChinaView) {
        this.mliveChinaView = liveChinaView;
        this.mUrl = url;
        mPandaChannelModelImp = new PandaChannelModelImp();
        //实例化PandaLiveContract中的Presenter的
        mliveChinaView.setPresenter(this);
    }

    @Override
    public void start() {
        mPandaChannelModelImp.getLiveData(mUrl,new MyCallBack<LiveChinaContentBean>() {
            @Override
            public void onSuccess(LiveChinaContentBean liveChinaContentBean) {
                mliveChinaView.setResultData(liveChinaContentBean);

            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }

}
