package com.example.a12710.pandachannel.module.panda_live;


import com.example.a12710.pandachannel.base.BasePresenter;
import com.example.a12710.pandachannel.base.BaseView;
import com.example.a12710.pandachannel.model.bean.PandaLiveBean;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 15:18
 * 作 者：T
 * 微信：704003376
 */

public interface PandaLiveContract {


    //PandaLiveView
    interface PandaLiveView extends BaseView<PandaLivePresenter> {
        //TODO请求各种数据更新UI
        void setResultData(PandaLiveBean pandaLiveBean);
    }


    //PandaLivePresenter
    interface PandaLivePresenter extends BasePresenter {


    }


}
