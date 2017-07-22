package com.example.a12710.pandachannel.module.panda_live.fragment;

import com.example.a12710.pandachannel.base.BasePresenter;
import com.example.a12710.pandachannel.base.BaseView;
import com.example.a12710.pandachannel.model.bean.LiveFlvBean;
import com.example.a12710.pandachannel.model.bean.PandaLiveBean;

/**
 * Created by 12710 on 2017/7/22.
 */

public interface LiveFragmentContrsct {
    interface LiveFragmentView extends BaseView<LiveFragmentPresenter>{
        void setLiveData(LiveFlvBean flvBean);
        void setResultData(PandaLiveBean pandaLiveBean);
    }
    interface LiveFragmentPresenter extends BasePresenter{};

}
