package com.example.a12710.pandachannel.module.live_china;

import android.view.View;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;

/**
 * Created by ASUS on 2017/7/19.
 */

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.LiveChinaView {
    LiveChinaContract.LiveChinaPresenter mLiveChinaPresenter;

    @Override
    public void setPresenter(LiveChinaContract.LiveChinaPresenter liveChinaPresenter) {
        this.mLiveChinaPresenter = liveChinaPresenter;
    }

    @Override
    protected void initData() {
        mLiveChinaPresenter = new LiveChinaPresenter(this);
        mLiveChinaPresenter.start();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_gun_gun;
    }


}
