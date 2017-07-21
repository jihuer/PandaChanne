package com.example.a12710.pandachannel.module.panda_live;

import com.example.a12710.pandachannel.model.PandaChannelModelImp;
import com.example.a12710.pandachannel.model.bean.PandaFragmentData;
import com.example.a12710.pandachannel.network.MyCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 12710 on 2017/7/20.
 */

public class PandaLivebasePresenter implements PandaLivebaseContrsct.LivebasePresenter {
    private PandaLivebaseContrsct.LivebaseView livebaseView;
    private PandaChannelModelImp mPandaChannelModelImp;
    private String id;
    private int p;
    public PandaLivebasePresenter(PandaLivebaseContrsct.LivebaseView livebaseView,String id,int p) {
        this.livebaseView = livebaseView;
        this.id = id;
        this.p = p;
        mPandaChannelModelImp = new PandaChannelModelImp();
    }

    @Override
    public void start() {
        Map<String,String> map = new HashMap<>();
        map.put("vsid",id);
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p",p+"");
        mPandaChannelModelImp.getPandaLivefragmentData(map, new MyCallBack<PandaFragmentData>() {
            @Override
            public void onSuccess(PandaFragmentData pandaFragmentData) {
                livebaseView.setPandaFragmentData(pandaFragmentData);
            }

            @Override
            public void onFaile(String msg) {


            }
        });
    }
}
