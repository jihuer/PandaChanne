package com.example.a12710.pandachannel.activity.loginPresent;

import com.example.a12710.pandachannel.base.BasePresenter;
import com.example.a12710.pandachannel.base.BaseView;
import com.example.a12710.pandachannel.model.bean.LoginBean;

/**
 * Created by 12710 on 2017/7/23.
 */

public interface LoginContract {
    interface LoginView extends BaseView<LoginPresent>{
        void setLogin(LoginBean login);
    }
    interface LoginPresent extends BasePresenter{
    }
}
