package com.example.a12710.pandachannel.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.example.a12710.pandachannel.module.PandaReport.PandaReportFragment;
import com.example.a12710.pandachannel.module.gungun_video.GunGunFragment;
import com.example.a12710.pandachannel.module.home.HomeFragment;
import com.example.a12710.pandachannel.module.live_china.LiveChinaFragmentHome;
import com.example.a12710.pandachannel.module.panda_live.PandaLiveFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    RadioButton radioHome;
    RadioButton radioPandachannel;
    RadioButton radioRollingvideo;
    RadioButton radioPandabroadcast;
    RadioButton radioLiveinchina;
    private HomeFragment homeFragment;
    private PandaLiveFragment liveFragmentnew;
    private GunGunFragment gunGunFragment;
    private PandaReportFragment pandaReportFragment;
    private LiveChinaFragmentHome liveChinaFragment;

    @Override
    protected void initView() {
        radioHome = (RadioButton) findViewById(R.id.radio_home);
        radioPandachannel = (RadioButton) findViewById(R.id.radio_pandachannel);
        radioRollingvideo = (RadioButton) findViewById(R.id.radio_rollingvideo);
        radioPandabroadcast = (RadioButton) findViewById(R.id.radio_pandabroadcast);
        radioLiveinchina = (RadioButton) findViewById(R.id.radio_liveinchina);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.add(R.id.home_fm, homeFragment);
        transaction.commit();
        setonclick();
    }

    private void setonclick() {
        radioHome.setOnClickListener(this);
        radioPandachannel.setOnClickListener(this);
        radioRollingvideo.setOnClickListener(this);
        radioPandabroadcast.setOnClickListener(this);
        radioLiveinchina.setOnClickListener(this);


    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    private void HideFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (liveFragmentnew != null) {
            transaction.hide(liveFragmentnew);
        }
        if (gunGunFragment != null) {
            transaction.hide(gunGunFragment);
        }
        if (pandaReportFragment != null) {
            transaction.hide(pandaReportFragment);
        }
        if (liveChinaFragment != null) {
            transaction.hide(liveChinaFragment);
        }

    }

    //@OnClick({R.id.radio_home, R.id.radio_pandachannel, R.id.radio_rollingvideo, R.id.radio_pandabroadcast, R.id.radio_liveinchina})
    @Override
    public void onClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        HideFragment(transaction);
        switch (view.getId()) {
            case R.id.radio_home:

                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.home_fm, homeFragment);
                }
                transaction.show(homeFragment);
                break;
            case R.id.radio_pandachannel:

                if (liveFragmentnew == null) {
                    liveFragmentnew = new PandaLiveFragment();
                    transaction.add(R.id.home_fm, liveFragmentnew);
                }
                transaction.show(liveFragmentnew);
                break;
            case R.id.radio_rollingvideo:

                if (gunGunFragment == null) {
                    gunGunFragment = new GunGunFragment();
                    transaction.add(R.id.home_fm, gunGunFragment);
                }
                transaction.show(gunGunFragment);
                break;
            case R.id.radio_pandabroadcast:

                if (pandaReportFragment == null) {
                    pandaReportFragment = new PandaReportFragment();
                    transaction.add(R.id.home_fm, pandaReportFragment);
                }
                transaction.show(pandaReportFragment);
                break;
            case R.id.radio_liveinchina:

                if (liveChinaFragment == null) {
                    liveChinaFragment = new LiveChinaFragmentHome();
                    transaction.add(R.id.home_fm, liveChinaFragment);
                }
                transaction.show(liveChinaFragment);
                break;
        }
        transaction.commit();
    }
    private long mPressedTime = 0;

    @Override
    public void onBackPressed() {
        long mNowTime = System.currentTimeMillis();//获取第一次按键时间
    if((mNowTime - mPressedTime) > 2000){//比较两次按键时间差
    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
    mPressedTime = mNowTime;
        } else{//退出程序
        this.finish();
            System.exit(0);
}
    }
}
