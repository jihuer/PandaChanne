package com.example.a12710.pandachannel.module.panda_live.fragment.multi_anglerfragment;

import com.example.a12710.pandachannel.base.BasePresenter;
import com.example.a12710.pandachannel.base.BaseView;
import com.example.a12710.pandachannel.model.bean.MultiBean;

/**
 * Created by 12710 on 2017/7/20.
 */

public interface MultiAngleContract {
    interface MultiAngleView extends BaseView<MultiAngleFragmentPresenter> {
        void setResultData(MultiBean multiBean);

    }
    //PandaLivePresenter
    interface MultiAnglePresenter extends BasePresenter {

    }
}
