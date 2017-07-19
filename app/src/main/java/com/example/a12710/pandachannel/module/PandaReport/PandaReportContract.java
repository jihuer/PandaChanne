package com.example.a12710.pandachannel.module.PandaReport;


import com.example.a12710.pandachannel.base.BasePresenter;
import com.example.a12710.pandachannel.base.BaseView;

/**
 * Created by 陆向阳 on 2017/7/19.
 */

public interface PandaReportContract {

    interface PandaReportView extends BaseView<PandaReportPresenter> {

    }

    interface PandaReportPresenter extends BasePresenter {
        void start();
    }

}
