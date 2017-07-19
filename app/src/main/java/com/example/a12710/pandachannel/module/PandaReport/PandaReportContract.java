package com.example.pandachannel.module.PandaReport;

import com.example.pandachannel.base.BasePresenter;
import com.example.pandachannel.base.BaseView;

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
