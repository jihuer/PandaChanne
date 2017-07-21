package com.example.a12710.pandachannel.module.PandaReport;


import com.example.a12710.pandachannel.model.PandaChannelModelImp;
import com.example.a12710.pandachannel.model.bean.PandaBroadBean;
import com.example.a12710.pandachannel.network.MyCallBack;

/**
 * Created by 陆向阳 on 2017/7/19
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
    /*    pandaChannelModelImp.getPandaBraodData(new MyCallBack<PandaBroadTwoBean>() {
            @Override
            public void onSuccess(PandaBroadTwoBean pandaBroadTwoBean) {
               pandaReportView.setResultData(pandaBroadTwoBean);

            }

            @Override
            public void onFaile(String msg) {

            }
        });*/
        pandaChannelModelImp.getPandaBroadData("iphoneInterface/general/getArticleAndVideoListInfo.json","PAGE1422435191506336","panda","6","1",new MyCallBack<PandaBroadBean>() {
            @Override
            public void onSuccess(PandaBroadBean pandaBroadBean) {
                pandaReportView.setResultData1(pandaBroadBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
