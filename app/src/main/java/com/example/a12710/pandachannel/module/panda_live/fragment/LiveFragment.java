package com.example.a12710.pandachannel.module.panda_live.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.PandaLiveBean;
import com.example.a12710.pandachannel.module.panda_live.PandaFragmentPresenter;
import com.example.a12710.pandachannel.module.panda_live.PandaLiveContract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.carbs.android.expandabletextview.library.ExpandableTextView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by 12710 on 2017/7/19.
 */

public class LiveFragment extends BaseFragment implements PandaLiveContract.PandaLiveView {
    @BindView(R.id.videocontroller1)
    JCVideoPlayerStandard videocontroller1;
    @BindView(R.id.tv_livetitle)
    TextView tvLivetitle;
    @BindView(R.id.checkbox_live)
    CheckBox checkboxLive;
    @BindView(R.id.etv)
    ExpandableTextView etv;
    @BindView(R.id.tab_live)
    TabLayout tabLive;
    @BindView(R.id.pager_live)
    ViewPager pagerLive;
    Unbinder unbinder;
    private PandaLiveContract.PandaLivePresenter mPandaLivPresenter;

    @Override
    protected void initData() {
        mPandaLivPresenter = new PandaFragmentPresenter(this);
        mPandaLivPresenter.start();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_live;
    }


    @Override
    public void setResultData(PandaLiveBean pandaLiveBean) {
        Log.e("TAG","=================setResultData==========================");
        Toast.makeText(getActivity(), pandaLiveBean.getLive().get(0).getUrl()+"", Toast.LENGTH_SHORT).show();
        videocontroller1.setUp(pandaLiveBean.getLive().get(0).getUrl(), JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, pandaLiveBean.getLive().get(0).getTitle());
        Glide.with(getActivity()).load(pandaLiveBean.getLive().get(0).getImage()).into(videocontroller1.thumbImageView);

    }

    @Override
    public void setPresenter(PandaLiveContract.PandaLivePresenter pandaLivePresenter) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
