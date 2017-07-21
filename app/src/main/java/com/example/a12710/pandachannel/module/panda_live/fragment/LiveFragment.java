package com.example.a12710.pandachannel.module.panda_live.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.adpter.MFragmentPagerAdapter;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.PandaLiveBean;
import com.example.a12710.pandachannel.model.bean.PandaLivetablist;
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
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


/**
 * Created by 12710 on 2017/7/19.
 * 直播
 */

public class LiveFragment extends BaseFragment implements PandaLiveContract.PandaLiveView {
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
    @BindView(R.id.surface_view)
    VideoView surfaceView;
    private MediaController mMediaController;

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
                switch (tab.getPosition()) {
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
        fragments.add(new Look_TalkFragment());
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
        //pandaLiveBean.getLive().get(0).getUrl()
        surfaceView.setVideoPath("http://114.236.140.76/vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/07/17/3d92fae34dc14b2492de15d5dd122ac8_h264200000nero_aac16.mp4?wshc_tag=0&wsts_tag=59716245&wsid_tag=73ab2078&wsiphost=ipdbm");
        surfaceView.requestFocus();
        mMediaController = new MediaController(getActivity());//实例化控制器
        mMediaController.show(5000);//控制器显示5s后自动隐藏
        surfaceView.setMediaController(mMediaController);//绑定控制器
        surfaceView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//设置播放画质 高画质
        surfaceView.requestFocus();//取得焦点
        surfaceView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
        tvLivetitle.setText("[正在直播]" + pandaLiveBean.getLive().get(0).getTitle());
        checkboxLive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
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
    public void setTabList(PandaLivetablist pandaLivetablist) {

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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
