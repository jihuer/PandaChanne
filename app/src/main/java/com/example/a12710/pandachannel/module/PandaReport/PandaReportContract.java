package com.example.a12710.pandachannel.module.PandaReport;


import com.example.a12710.pandachannel.base.BasePresenter;
import com.example.a12710.pandachannel.base.BaseView;
import com.example.a12710.pandachannel.model.bean.PandaBroadTwoBean;

/**
 * Created by 陆向阳 on 2017/7/19.
 */

public interface PandaReportContract {

    interface PandaReportView extends BaseView<PandaReportPresenter> {
        void setResultData(PandaBroadTwoBean pandaBroadTwoBean);
//        void setResultData1(PandaBroadBean pandaBroadBean);
    }

    interface PandaReportPresenter extends BasePresenter {

    }

}
