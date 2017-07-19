package com.example.a12710.pandachannel.module.home;

import android.view.View;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.HomeDataBean;


/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 14:21
 * 作 者：T
 * 微信：704003376
 */

public class HomeFragment extends BaseFragment implements HomeContract.HomeView {
    //TODO mHomePresenter未初始化
    private HomeContract.HomePresenter mHomePresenter;

    @Override
    public void setPresenter(HomeContract.HomePresenter presenter) {
        mHomePresenter = presenter;
    }


    @Override
    public void setResultData(HomeDataBean bean) {
        //更新UI

    }

    @Override
    protected void initData() {
        //通过P层处理相关业务逻辑
        mHomePresenter = new HomePresenter(this);
        mHomePresenter.start();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_pandalive;
    }
}
