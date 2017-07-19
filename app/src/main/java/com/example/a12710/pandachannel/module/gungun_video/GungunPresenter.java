package com.example.a12710.pandachannel.module.gungun_video;


import com.example.a12710.pandachannel.model.PandaChannelModelImp;
import com.example.a12710.pandachannel.model.bean.RollRollVideoBean;
import com.example.a12710.pandachannel.network.MyCallBack;

/**
 * Created by 陆向阳 on 2017/7/18.
 */

public class GungunPresenter implements GungunContract.gungunlivepresenter {
    private GungunContract.gungunlive gungunlive;
    private PandaChannelModelImp pandaChannelModelImp;

    public GungunPresenter(GungunContract.gungunlive gungunlive) {
        this.gungunlive = gungunlive;
        pandaChannelModelImp = new PandaChannelModelImp();
        gungunlive.setPresenter(this);
    }

    @Override
    public void start() {
        pandaChannelModelImp.getRollVideoData(new MyCallBack<RollRollVideoBean>() {
            @Override
            public void onSuccess(RollRollVideoBean rollRollVideoBean) {

            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
