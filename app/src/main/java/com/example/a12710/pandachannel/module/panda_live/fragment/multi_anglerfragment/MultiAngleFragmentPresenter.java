package com.example.a12710.pandachannel.module.panda_live.fragment.multi_anglerfragment;

import com.example.a12710.pandachannel.model.PandaChannelModelImp;
import com.example.a12710.pandachannel.model.bean.MultiBean;
import com.example.a12710.pandachannel.network.MyCallBack;

/**
 * Created by 12710 on 2017/7/20.
 */

public class MultiAngleFragmentPresenter implements MultiAngleContract.MultiAnglePresenter {
    private MultiAngleContract.MultiAngleView multiAngleView;
    private PandaChannelModelImp mPandaChannelModelImp;

    public MultiAngleFragmentPresenter(MultiAngleContract.MultiAngleView multiAngleView) {
        this.multiAngleView = multiAngleView;
        mPandaChannelModelImp = new PandaChannelModelImp();
    }

    @Override
    public void start() {
        mPandaChannelModelImp.getMultiData(new MyCallBack<MultiBean>() {
            @Override
            public void onSuccess(MultiBean multiBean) {
                multiAngleView.setResultData(multiBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
