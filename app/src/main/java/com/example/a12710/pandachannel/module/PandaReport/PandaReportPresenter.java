package com.example.a12710.pandachannel.module.PandaReport;


import com.example.a12710.pandachannel.model.PandaChannelModelImp;
import com.example.a12710.pandachannel.model.bean.PandaBroadTwoBean;
import com.example.a12710.pandachannel.network.MyCallBack;

/**
 * Created by 陆向阳 on 2017/7/19.
 */

public class PandaReportPresenter implements PandaReportContract.PandaReportPresenter {
    private PandaReportContract.PandaReportView pandaReportView;
    private PandaChannelModelImp pandaChannelModelImp;

    public PandaReportPresenter(PandaReportContract.PandaReportView pandaReportView) {
        this.pandaReportView = pandaReportView;
        pandaChannelModelImp = new PandaChannelModelImp();
        pandaReportView.setPresenter(this);
    }

    @Override
    public void start() {
        pandaChannelModelImp.getPandaBraodData(new MyCallBack<PandaBroadTwoBean>() {
            @Override
            public void onSuccess(PandaBroadTwoBean pandaBroadTwoBean) {

            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
