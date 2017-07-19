package com.example.a12710.pandachannel.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.example.a12710.pandachannel.module.PandaReport.PandaReportFragment;
import com.example.a12710.pandachannel.module.gungun_video.GunGunFragment;
import com.example.a12710.pandachannel.module.home.HomeFragment;
import com.example.a12710.pandachannel.module.live_china.LiveChinaFragment;
import com.example.a12710.pandachannel.module.panda_live.PandaLiveFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.radio_home)
    RadioButton radioHome;
    @BindView(R.id.radio_pandachannel)
    RadioButton radioPandachannel;
    @BindView(R.id.radio_rollingvideo)
    RadioButton radioRollingvideo;
    @BindView(R.id.radio_pandabroadcast)
    RadioButton radioPandabroadcast;
    @BindView(R.id.radio_liveinchina)
    RadioButton radioLiveinchina;
    @BindView(R.id.home_line)
    LinearLayout homeLine;
    @BindView(R.id.home_fm)
    FrameLayout homeFm;
    private HomeFragment homeFragment;
    private PandaLiveFragment liveFragmentnew;
    private GunGunFragment gunGunFragment;
    private PandaReportFragment pandaReportFragment;
    private LiveChinaFragment liveChinaFragment;

    @Override
    protected void initView() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.add(R.id.home_fm, homeFragment);
        transaction.commit();
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.radio_home, R.id.radio_pandachannel, R.id.radio_rollingvideo, R.id.radio_pandabroadcast, R.id.radio_liveinchina})
    public void onViewClicked(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        HideFragment(transaction);
        switch (view.getId()) {
            case R.id.radio_home:
                if(homeFragment==null){
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.home_fm, homeFragment);
                }
                transaction.show(homeFragment);
                break;
            case R.id.radio_pandachannel:
                if(liveFragmentnew==null){
                    liveFragmentnew = new PandaLiveFragment();
                    transaction.add(R.id.home_fm, liveFragmentnew);
                }
                transaction.show(liveFragmentnew);
                break;
            case R.id.radio_rollingvideo:
                if(gunGunFragment==null){
                    gunGunFragment = new GunGunFragment();
                    transaction.add(R.id.home_fm, gunGunFragment);
                }
                transaction.show(gunGunFragment);
                break;
            case R.id.radio_pandabroadcast:
                if(pandaReportFragment==null){
                    pandaReportFragment = new PandaReportFragment();
                    transaction.add(R.id.home_fm, pandaReportFragment);
                }
                transaction.show(pandaReportFragment);
                break;
            case R.id.radio_liveinchina:
                if(liveChinaFragment==null){
                    liveChinaFragment = new LiveChinaFragment();
                    transaction.add(R.id.home_fm, liveChinaFragment);
                }
                transaction.show(liveChinaFragment);
                break;
        }
        transaction.commit();
    }

    private void HideFragment(FragmentTransaction transaction) {
        if (homeFragment!=null){
            transaction.hide(homeFragment);
        }if (liveFragmentnew!=null){
            transaction.hide(liveFragmentnew);
        }if (gunGunFragment!=null){
            transaction.hide(gunGunFragment);
        }if (pandaReportFragment!=null){
            transaction.hide(pandaReportFragment);
        }if (liveChinaFragment!=null){
            transaction.hide(liveChinaFragment);
        }

    }
}
