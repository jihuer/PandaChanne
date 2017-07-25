package com.example.a12710.pandachannel.module.panda_live.fragment;

import com.example.a12710.pandachannel.model.PandaChannelModelImp;
import com.example.a12710.pandachannel.model.bean.LiveFlvBean;
import com.example.a12710.pandachannel.model.bean.PandaLiveBean;
import com.example.a12710.pandachannel.network.MyCallBack;

/**
 * Created by 12710 on 2017/7/22.
 */

public class LiveFragmentPresenter implements LiveFragmentContrsct.LiveFragmentPresenter {
    private LiveFragmentContrsct.LiveFragmentView liveFragmentView;
    private PandaChannelModelImp pandaChannelModelImp;

    private String path = "";
    public LiveFragmentPresenter(LiveFragmentContrsct.LiveFragmentView liveFragmentView,String path) {
        this.liveFragmentView = liveFragmentView;
        pandaChannelModelImp = new PandaChannelModelImp();
        this.path = path;
    }

    @Override
    public void start() {
        pandaChannelModelImp.getPandaLiveData(new MyCallBack<PandaLiveBean>() {

            @Override
            public void onSuccess(PandaLiveBean pandaLiveBean) {
                liveFragmentView.setResultData(pandaLiveBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
        pandaChannelModelImp.getPandaLive(path, new MyCallBack<LiveFlvBean>() {
            @Override
            public void onSuccess(LiveFlvBean liveFlvBean) {
                liveFragmentView.setLiveData(liveFlvBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }

    public void setpath(String path) {
        this.path = path;
        start();
    }
}
