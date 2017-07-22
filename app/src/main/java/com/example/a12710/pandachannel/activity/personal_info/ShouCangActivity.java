package com.example.a12710.pandachannel.activity.personal_info;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.example.a12710.pandachannel.base.BaseFragment;

import java.util.ArrayList;

public class ShouCangActivity extends BaseActivity {

    private ViewPager vp;
    private TabLayout tabLayout;
    private ArrayList<BaseFragment> list;

    @Override
    protected void initView() {

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_shou_cang;
    }
}
