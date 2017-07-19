package com.example.a12710.pandachannel.module.gungun_video;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;


public class GunGunFragment extends BaseFragment implements GungunContract.gungunlive {
    private GungunContract.gungunlivepresenter gungunlivepresenter;
    private TextView gungunTitle;

    @Override
    public void setPresenter(GungunContract.gungunlivepresenter gungunlivepresenter) {
        this.gungunlivepresenter = gungunlivepresenter;
    }

    @Override
    protected void initData() {
        gungunTitle.setText("滚滚视频");
        gungunTitle.setTextColor(Color.WHITE);
        gungunTitle.setTextSize(20);
    }

    @Override
    protected void initView(View view) {
        gungunTitle = (TextView) view.findViewById(R.id.toobar_title);
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_gun_gun;
    }
}
