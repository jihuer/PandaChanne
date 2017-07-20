package com.example.a12710.pandachannel.module.live_china;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.adpter.MFragmentPagerAdapter;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.LiveChinaBean;
import com.example.a12710.pandachannel.module.live_china.live_china_content.LiveChinaFragment;
import com.example.a12710.pandachannel.module.live_china.live_china_content.LiveChinaPresenter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ASUS on 2017/7/19.
 */

public class LiveChinaFragmentHome extends BaseFragment implements LiveChinaTabContract.LiveChinaTabView{
    LiveChinaTabContract.LiveChinaTabPresenter mliveChinaTabPresenter;
    TabLayout tabLayout;
    ImageView add;
    ViewPager viewPager;
    List<Fragment> fragmentList;
    List<String> titleList;
    MFragmentPagerAdapter adapter;
    @Override
    public void setPresenter(LiveChinaTabContract.LiveChinaTabPresenter liveChinaTabPresenter) {
    this.mliveChinaTabPresenter = liveChinaTabPresenter;
    }

    @Override
    protected void initData() {
        mliveChinaTabPresenter = new LiveChinaTabPresenter(this);
        mliveChinaTabPresenter.start();


    }

    @Override
    protected void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.lc_tab);
        add = (ImageView) view.findViewById(R.id.lc_add);
        viewPager = (ViewPager) view.findViewById(R.id.lc_vp);
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_livechina;
    }



    @Override
    public void setResultData(LiveChinaBean liveChinaBean) {
        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();
        for (int i = 0; i <liveChinaBean.getTablist().size(); i++) {
            fragmentList.add(new LiveChinaFragment(liveChinaBean.getTablist().get(i).getUrl()));
            titleList.add(liveChinaBean.getTablist().get(i).getTitle());
        }

        adapter = new MFragmentPagerAdapter(getChildFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
}
