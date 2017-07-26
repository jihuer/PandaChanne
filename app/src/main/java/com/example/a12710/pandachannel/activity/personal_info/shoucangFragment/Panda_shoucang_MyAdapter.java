package com.example.a12710.pandachannel.activity.personal_info.shoucangFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.a12710.pandachannel.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by dell on 2017/7/22.
 */

public class Panda_shoucang_MyAdapter extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> list;
    private String str [] = {"直播","精彩看点"};
    public Panda_shoucang_MyAdapter(FragmentManager fm,ArrayList<BaseFragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
