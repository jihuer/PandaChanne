package com.example.a12710.pandachannel.module.panda_live;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.adpter.MFragmentPagerAdapter;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.PandaLiveBean;
import com.example.a12710.pandachannel.model.bean.PandaLivetablist;
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

public class PandaLiveFragment extends BaseFragment implements PandaLiveContract.PandaLiveView {
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
    @Override
    protected void initData() {
        PandaFragmentPresenter pandaFragmentPresenter = new PandaFragmentPresenter(this);
        pandaFragmentPresenter.start();
    }

    @Override
    protected void initView(View view) {

        toobarTitle.setText("熊猫直播");
        pandaliveTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        pandaliveTab.setupWithViewPager(pandalivePager);
        initPagerData();

    }

    private void initPagerData() {
        PandaFragmentPresenter pandaFragmentPresenter = new PandaFragmentPresenter(this);
        pandaFragmentPresenter.start();
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

    @Override
    public void setPresenter(PandaLiveContract.PandaLivePresenter pandaLivePresenter) {

    }

    @Override
    public void setResultData(PandaLiveBean pandaLiveBean) {

    }

    @Override
    public void setTabList(PandaLivetablist pandaLivetablist) {
        Log.e("TAG","================setTabList=======================");
        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        fragments.add(new LiveFragment());
        for (int i = 0; i < pandaLivetablist.getTablist().size(); i++) {
            titles.add(pandaLivetablist.getTablist().get(i).getTitle());
            if (i>0){
                Bundle bundle = new Bundle();
                bundle.putString("vsid",pandaLivetablist.getTablist().get(i).getId());
                PandaLiveBaseFragment pandaLiveBaseFragment = new PandaLiveBaseFragment();
                pandaLiveBaseFragment.setArguments(bundle);
                fragments.add(pandaLiveBaseFragment);
            }
        }

        MFragmentPagerAdapter pagerAdapter = new MFragmentPagerAdapter(getActivity().getSupportFragmentManager(),fragments,titles);
        pandalivePager.setAdapter(pagerAdapter);
    }
}
