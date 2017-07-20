package com.example.a12710.pandachannel.module.live_china;

import com.example.a12710.pandachannel.base.BasePresenter;
import com.example.a12710.pandachannel.base.BaseView;
import com.example.a12710.pandachannel.model.bean.LiveChinaBean;

/**
 * Created by ASUS on 2017/7/19.
 */

public interface LiveChinaContract {
    //View
    interface LiveChinaView extends BaseView<LiveChinaPresenter> {
        //TODO请求各种数据更新UI
        void setResultData(LiveChinaBean liveChinaBean);
    }


    //Presenter
    interface LiveChinaPresenter extends BasePresenter {

    }
}
