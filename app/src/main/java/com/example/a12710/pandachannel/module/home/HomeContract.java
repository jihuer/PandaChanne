package com.example.a12710.pandachannel.module.home;


import com.example.a12710.pandachannel.base.BasePresenter;
import com.example.a12710.pandachannel.base.BaseView;
import com.example.a12710.pandachannel.model.bean.HomeDataBean;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 14:14
 * 作 者：T
 * 微信：704003376
 * 契约类  将 M层 V层, P层 对应的接口都放里面
 */
public interface HomeContract {

    //View
    interface HomeView extends BaseView<HomePresenter> {
        void setResultData(HomeDataBean dataBean);
    }


    //Presenter
    interface HomePresenter extends BasePresenter {

    }


}
