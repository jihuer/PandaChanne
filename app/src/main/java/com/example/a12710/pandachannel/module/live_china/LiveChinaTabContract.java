package com.example.a12710.pandachannel.module.live_china;

import com.example.a12710.pandachannel.base.BasePresenter;
import com.example.a12710.pandachannel.base.BaseView;
import com.example.a12710.pandachannel.model.bean.LiveChinaBean;
import com.example.a12710.pandachannel.model.bean.LiveChinaContentBean;

/**
 * Created by ASUS on 2017/7/19.
 */

public interface LiveChinaTabContract {
    //View
    interface LiveChinaTabView extends BaseView<LiveChinaTabPresenter> {
        //TODO请求各种数据更新UI
        void setResultData(LiveChinaBean liveChinaBean);
    }


    //Presenter
    interface LiveChinaTabPresenter extends BasePresenter {

    }
}
