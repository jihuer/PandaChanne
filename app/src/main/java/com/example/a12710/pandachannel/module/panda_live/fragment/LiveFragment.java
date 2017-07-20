package com.example.a12710.pandachannel.module.panda_live.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.adpter.MFragmentPagerAdapter;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.PandaLiveBean;
import com.example.a12710.pandachannel.module.panda_live.PandaFragmentPresenter;
import com.example.a12710.pandachannel.module.panda_live.PandaLiveContract;
import com.example.a12710.pandachannel.module.panda_live.fragment.looktalkfragment.Look_TalkFragment;
import com.example.a12710.pandachannel.module.panda_live.fragment.multi_anglerfragment.multi_angleFragment;
import com.example.a12710.pandachannel.view.MViewpager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by 12710 on 2017/7/19.
 * 直播
 */

public class LiveFragment extends BaseFragment implements PandaLiveContract.PandaLiveView {
    @BindView(R.id.videocontroller1)
    JCVideoPlayerStandard videocontroller1;
    @BindView(R.id.tv_livetitle)
    TextView tvLivetitle;
    @BindView(R.id.checkbox_live)
    CheckBox checkboxLive;
    @BindView(R.id.etv)
    TextView etv;
    @BindView(R.id.tab_live)
    TabLayout tabLive;
    @BindView(R.id.pager_live)
    MViewpager pagerLive;
    Unbinder unbinder;


    PandaLiveContract.PandaLivePresenter mPandaLivPresenter;
    @BindView(R.id.bt_livesend)
    Button btLivesend;
    @BindView(R.id.ed_live)
    EditText edLive;
    @BindView(R.id.live_re)
    RelativeLayout liveRe;

    @Override
    protected void initData() {
        mPandaLivPresenter = new PandaFragmentPresenter(this);
        mPandaLivPresenter.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)

    @Override
    protected void initView(View view) {
        tabLive.setTabMode(TabLayout.MODE_FIXED);
        tabLive.setupWithViewPager(pagerLive);
        initpageData();
        tabLive.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        liveRe.setVisibility(View.GONE);
                    break;
                    case 1:
                        liveRe.setVisibility(View.VISIBLE);
                        break;

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initpageData() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new multi_angleFragment());
        fragments .add(new Look_TalkFragment());
        List<String> titles = new ArrayList<>();
        titles.add("多视角直播");
        titles.add("边看边聊");
        MFragmentPagerAdapter pagerAdapter = new MFragmentPagerAdapter(getChildFragmentManager(), fragments, titles);
        pagerLive.setAdapter(pagerAdapter);
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    public void setResultData(final PandaLiveBean pandaLiveBean) {
        videocontroller1.setUp(pandaLiveBean.getLive().get(0).getUrl(), JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, pandaLiveBean.getLive().get(0).getTitle());
        Glide.with(getActivity()).load(pandaLiveBean.getLive().get(0).getImage()).into(videocontroller1.thumbImageView);
        tvLivetitle.setText("[正在直播]" + pandaLiveBean.getLive().get(0).getTitle());
        checkboxLive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getActivity(), isChecked + "", Toast.LENGTH_SHORT).show();
                if (isChecked) {
                    etv.setVisibility(View.VISIBLE);
                    etv.setText(pandaLiveBean.getLive().get(0).getBrief());
                } else {
                    etv.setVisibility(View.GONE);
                }
            }
        });

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
