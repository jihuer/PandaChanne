package com.example.a12710.pandachannel.module.panda_live;

import com.example.a12710.pandachannel.base.BasePresenter;
import com.example.a12710.pandachannel.base.BaseView;
import com.example.a12710.pandachannel.model.bean.PandaFragmentData;

/**
 * Created by 12710 on 2017/7/20.
 */

public interface PandaLivebaseContrsct {
    interface LivebaseView extends BaseView<PandaLivebasePresenter>{
        void setPandaFragmentData(PandaFragmentData pandaFragmentData);
    }
    interface LivebasePresenter extends BasePresenter {
    }
}
