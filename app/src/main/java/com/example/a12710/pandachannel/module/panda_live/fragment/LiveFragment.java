package com.example.a12710.pandachannel.module.panda_live.fragment;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.adpter.MFragmentPagerAdapter;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.LiveFlvBean;
import com.example.a12710.pandachannel.model.bean.PandaLiveBean;
import com.example.a12710.pandachannel.module.panda_live.fragment.looktalkfragment.LookTalkFragment;
import com.example.a12710.pandachannel.module.panda_live.fragment.multi_anglerfragment.LivepathEvent;
import com.example.a12710.pandachannel.module.panda_live.fragment.multi_anglerfragment.Multi_angleFragment;
import com.example.a12710.pandachannel.view.MViewpager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.vov.vitamio.widget.VideoView;


/**
 * Created by 12710 on 2017/7/19.
 * 直播
 */

public class LiveFragment extends BaseFragment implements LiveFragmentContrsct.LiveFragmentView {

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
    @BindView(R.id.tv)
    TextView tv;
    private String path = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hdxiongmao08&client=androidapp";
    private ProgressDialog progressBar;
    @BindView(R.id.videoplayer)
    VideoView videoplayer;
    private List<PandaLiveBean.LiveBean> list = new ArrayList();
    private LiveFragmentPresenter liveFragmentPresenter;

    @Override
    protected void initData() {
        liveFragmentPresenter = new LiveFragmentPresenter(this, path);
        liveFragmentPresenter.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)

    @Override
    protected void initView(View view) {
        EventBus.getDefault().register(this);//订阅
        tabLive.setTabMode(TabLayout.MODE_FIXED);
        tabLive.setupWithViewPager(pagerLive);
        initpageData();
        progressBar = new ProgressDialog(getActivity());
    }

    private void initpageData() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Multi_angleFragment());
        fragments.add(new LookTalkFragment());
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
        if (pandaLiveBean != null) {
            list.addAll(pandaLiveBean.getLive());
            //tvLivetitle.setText("[正在直播]" + pandaLiveBean.getLive().get(0).getTitle());
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
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void LivepathEvent(LivepathEvent livepathEvent) {

        liveFragmentPresenter.setpath(livepathEvent.getPath());
        //Toast.makeText(getActivity(),list.get(livepathEvent.getPostation()).getTitle(), Toast.LENGTH_SHORT).show();
        tvLivetitle.setText("[正在直播]" + livepathEvent.getPostation());
        Log.e("TAG", "LivepathEvent: " + path);
        /*Toast.makeText(getActivity(), path+"", Toast.LENGTH_SHORT).show();*/
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
        EventBus.getDefault().unregister(this);//订阅

    }

    @Override
    public void setPresenter(LiveFragmentContrsct.LiveFragmentPresenter liveFragmentPresenter) {

    }

    @Override
    public void setLiveData(LiveFlvBean flvBean) {
        //progressBar.show();
        videoplayer.setVideoURI(Uri.parse(flvBean.getFlv_url().getFlv2()));
        //MediaPlayer mediaPlayer = new MediaPlayer(getActivity());
        videoplayer.requestFocus();
       /* if (videoplayer.isBuffering()) {
            progressBar.dismiss();
        }*/
        videoplayer.start();
    }


    @OnClick(R.id.tv)
    public void onViewClicked() {
            if (tv.getText().equals("开始")){
                videoplayer.start();
                tv.setText("暂停");
                Toast.makeText(getActivity(), "开始", Toast.LENGTH_SHORT).show();
            }else {
                videoplayer.pause();
                tv.setText("开始");
                Toast.makeText(getActivity(), "暂停", Toast.LENGTH_SHORT).show();

            }


    }
}
