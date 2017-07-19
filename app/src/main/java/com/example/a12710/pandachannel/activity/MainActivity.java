package com.example.a12710.pandachannel.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.example.a12710.pandachannel.module.PandaReport.PandaReportFragment;
import com.example.a12710.pandachannel.module.gungun_video.GunGunFragment;
import com.example.a12710.pandachannel.module.home.HomeFragment;
import com.example.a12710.pandachannel.module.live_china.LiveChinaFragment;
import com.example.a12710.pandachannel.module.panda_live.PandaLiveFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    RadioButton radioHome;
    RadioButton radioPandachannel;
    RadioButton radioRollingvideo;
    RadioButton radioPandabroadcast;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
                Toast.makeText(this, "radio_home", Toast.LENGTH_SHORT).show();
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.home_fm, homeFragment);
                }
                transaction.show(homeFragment);
                break;
            case R.id.radio_pandachannel:
                Toast.makeText(this, "radio_pandachannel", Toast.LENGTH_SHORT).show();
                if (liveFragmentnew == null) {
                    liveFragmentnew = new PandaLiveFragment();
                    transaction.add(R.id.home_fm, liveFragmentnew);
                }
                transaction.show(liveFragmentnew);
                break;
            case R.id.radio_rollingvideo:
                Toast.makeText(this, "radio_rollingvideo", Toast.LENGTH_SHORT).show();
                if (gunGunFragment == null) {
                    gunGunFragment = new GunGunFragment();
                    transaction.add(R.id.home_fm, gunGunFragment);
                }
                transaction.show(gunGunFragment);
                break;
            case R.id.radio_pandabroadcast:
                Toast.makeText(this, "radio_pandabroadcast", Toast.LENGTH_SHORT).show();
                if (pandaReportFragment == null) {
                    pandaReportFragment = new PandaReportFragment();
                    transaction.add(R.id.home_fm, pandaReportFragment);
                }
                transaction.show(pandaReportFragment);
                break;
            case R.id.radio_liveinchina:
                Toast.makeText(this, "radio_liveinchina", Toast.LENGTH_SHORT).show();
                if (liveChinaFragment == null) {
                    liveChinaFragment = new LiveChinaFragment();
                    transaction.add(R.id.home_fm, liveChinaFragment);
                }
                transaction.show(liveChinaFragment);
                break;
        }
        transaction.commit();
    }


}
