package com.example.a12710.pandachannel.module.panda_live;

import android.view.View;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.PandaLiveBean;


/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 15:23
 * 作 者：T
 * 微信：704003376
 *
 * 熊猫直播模块的View层  需要通过P层处理逻辑并且获取数据
 */

public class PandaLiveFragment extends BaseFragment implements PandaLiveContract.PandaLiveView {
  private PandaLiveContract.PandaLivePresenter  mPandaLivPresenter;


    @Override
    public void setPresenter(PandaLiveContract.PandaLivePresenter pandaLivePresenter) {
        mPandaLivPresenter=pandaLivePresenter;
    }

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
        return R.layout.fragment_gun_gun;
    }

  @Override
  public void setResultData(PandaLiveBean pandaLiveBean) {

  }
}
