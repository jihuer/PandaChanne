package com.example.a12710.pandachannel.module.panda_live;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.adpter.MFragmentPagerAdapter;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.module.panda_live.fragment.LiveFragment;
import com.example.a12710.pandachannel.view.MViewpager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 15:23
 * 作 者：T
 * 微信：704003376
 * <p>
 * 熊猫直播模块的View层  需要通过P层处理逻辑并且获取数据
 */

public class PandaLiveFragment extends BaseFragment  {
    @BindView(R.id.toobar_logo)
    ImageView toobarLogo;
    @BindView(R.id.toobar_title)
    TextView toobarTitle;
    @BindView(R.id.toobar_sign)
    ImageView toobarSign;
    @BindView(R.id.pandalive_tab)
    TabLayout pandaliveTab;
    @BindView(R.id.pandalive_pager)
    MViewpager pandalivePager;
    Unbinder unbinder;
    /*  private TextView toobarTitle;
        private ImageView toobarSign;
        private TabLayout pandalive_tab;
        private ViewPager viewPager;*/





    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        /*toobarTitle = (TextView) view.findViewById(R.id.toobar_title);
        toobarSign = (ImageView) view.findViewById(R.id.toobar_sign);
        pandaliveTab = (TabLayout) view.findViewById(R.id.pandalive_tab);
        pandalivePager = (MViewpager) view.findViewById(R.id.pandalive_pager);*/
        toobarTitle.setText("熊猫直播");
        pandaliveTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        pandaliveTab.setupWithViewPager(pandalivePager);
        initPagerData();

    }

    private void initPagerData() {
        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        titles.add("直播");
        titles.add("精彩一刻");
        titles.add("当熊不让");
        titles.add("超萌滚滚秀");
        titles.add("熊猫档案");
        titles.add("熊猫TOP榜");
        titles.add("熊猫那些事");
        titles.add("特别节目");
        titles.add("原创新闻");
        fragments.add(new LiveFragment());
        fragments.add(new LiveFragment());
        MFragmentPagerAdapter pagerAdapter = new MFragmentPagerAdapter(getActivity().getSupportFragmentManager(),fragments,titles);
        pandalivePager.setAdapter(pagerAdapter);
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_pandalive;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
