package com.example.a12710.pandachannel.activity.personal_info;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.activity.personal_info.SettingFragment.FragmentChangjian;
import com.example.a12710.pandachannel.activity.personal_info.SettingFragment.FragmentYudaode;
import com.example.a12710.pandachannel.adpter.MFragmentPagerAdapter;
import com.example.a12710.pandachannel.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/7/24.
 */

public class SettingTicklingActivity extends BaseActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView imageView;
    @Override
    protected void initView() {
        imageView = (ImageView) findViewById(R.id.tickling_fanhui);
        tabLayout = (TabLayout) findViewById(R.id.tickling_tab);
        viewPager = (ViewPager) findViewById(R.id.tickling_pager);

        List<Fragment> fragments=new ArrayList<>();
        List<String> titles=new ArrayList<>();
        fragments.add(new FragmentYudaode());
        fragments.add(new FragmentChangjian());

        titles.add("遇到的问题");
        titles.add("常见问题");
        MFragmentPagerAdapter adapter = new MFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        initData();
        initListener();
    }

    private void initData() {
    }

    private void initListener() {
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_setting_tickling;
    }
}
