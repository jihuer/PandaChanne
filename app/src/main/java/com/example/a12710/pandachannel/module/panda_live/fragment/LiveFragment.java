package com.example.a12710.pandachannel.module.panda_live.fragment;

import android.view.View;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.PandaLiveBean;
import com.example.a12710.pandachannel.module.panda_live.PandaFragmentPresenter;
import com.example.a12710.pandachannel.module.panda_live.PandaLiveContract;

/**
 * Created by 12710 on 2017/7/19.
 */

public class LiveFragment extends BaseFragment implements PandaLiveContract.PandaLiveView{
    private PandaLiveContract.PandaLivePresenter mPandaLivPresenter;
    @Override
    protected void initData() {
        mPandaLivPresenter = new PandaFragmentPresenter(this);
        mPandaLivPresenter.start();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_live;
    }


    @Override
    public void setResultData(PandaLiveBean pandaLiveBean) {

    }

    @Override
    public void setPresenter(PandaLiveContract.PandaLivePresenter pandaLivePresenter) {

    }
}
