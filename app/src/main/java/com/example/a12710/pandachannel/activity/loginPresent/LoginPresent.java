package com.example.a12710.pandachannel.activity.loginPresent;

import android.widget.Toast;

import com.example.a12710.pandachannel.global.MyApp;
import com.example.a12710.pandachannel.model.PandaChannelModelImp;
import com.example.a12710.pandachannel.model.bean.LoginBean;
import com.example.a12710.pandachannel.network.MyCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 12710 on 2017/7/23.
 */

public class LoginPresent implements LoginContract.LoginPresent{
    private LoginContract.LoginView loginView;
    private String psw,username;
    private PandaChannelModelImp pandaChannelModelImp;
    public LoginPresent(LoginContract.LoginView loginView,String username,String psw) {
        this.loginView = loginView;
        this.psw = psw;
        this.username = username;
        pandaChannelModelImp = new PandaChannelModelImp();
    }

    @Override
    public void start() {
        if (!username.equals("")&&!psw.equals("")){
            Map<String,String> map = new HashMap<>();
            map.put("from","https://reg.cntv.cn/login/login.action");
            map.put("password",psw);
            map.put("service","client_transaction");
            map.put("username",username);
            pandaChannelModelImp.getLoginData(map, new MyCallBack<LoginBean>() {
                @Override
                public void onSuccess(LoginBean loginBean) {
                    loginView.setLogin(loginBean);
                }

                @Override
                public void onFaile(String msg) {

                }
            });
        }if (username.equals("")||psw.equals("")){
            Toast.makeText(MyApp.mContext, "密码或账号为空", Toast.LENGTH_SHORT).show();
        }

    }
}
