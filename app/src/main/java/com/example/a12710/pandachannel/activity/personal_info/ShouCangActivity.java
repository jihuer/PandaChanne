package com.example.a12710.pandachannel.activity.personal_info;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.activity.personal_info.shoucangFragment.Panda_shoucang_MyAdapter;
import com.example.a12710.pandachannel.activity.personal_info.shoucangFragment.ShouCang_KanDian;
import com.example.a12710.pandachannel.activity.personal_info.shoucangFragment.ShouCang_ZhiBoFragment;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.example.a12710.pandachannel.base.BaseFragment;

import java.util.ArrayList;

public class ShouCangActivity extends BaseActivity {

    private ViewPager vp;
    private TabLayout tabLayout;
    private ArrayList<BaseFragment> list;
    private Panda_shoucang_MyAdapter adapter;
    private TextView bianji;

    @Override
    protected void initView() {
        bianji = (TextView) findViewById(R.id.shoucang_bianji);
        vp = (ViewPager) findViewById(R.id.shoucang_vp);
        tabLayout = (TabLayout) findViewById(R.id.shoucang_tab);
        list = new ArrayList<>();
        list.add(new ShouCang_ZhiBoFragment());
        list.add(new ShouCang_KanDian());

        adapter = new Panda_shoucang_MyAdapter(getSupportFragmentManager(),list);
        vp.setAdapter(adapter);

        tabLayout.setupWithViewPager(vp);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_shou_cang;
    }
}
