package com.example.pandachannel.module.gungun_video;

import com.example.pandachannel.base.BasePresenter;
import com.example.pandachannel.base.BaseView;

/**
 * Created by 陆向阳 on 2017/7/18.
 */

public interface GungunContract {
    interface gungunlive extends BaseView<gungunlivepresenter> {

    }

    interface gungunlivepresenter extends BasePresenter {
        void start();
    }
}
