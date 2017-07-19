package com.example.a12710.pandachannel.module.panda_live;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.PandaLiveBean;

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
    Unbinder unbinder;
    private PandaLiveContract.PandaLivePresenter mPandaLivPresenter;


    @Override
    public void setPresenter(PandaLiveContract.PandaLivePresenter pandaLivePresenter) {
        mPandaLivPresenter = pandaLivePresenter;
    }

    @Override
    protected void initData() {
        mPandaLivPresenter = new PandaFragmentPresenter(this);
        mPandaLivPresenter.start();
    }

    @Override
    protected void initView(View view) {
       // toobarTitle.setText("熊猫直播");
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_pandalive;
    }

    @Override
    public void setResultData(PandaLiveBean pandaLiveBean) {
        Log.e("TAG", "===========setResultData======================");
        Toast.makeText(getActivity(), pandaLiveBean.toString() + "", Toast.LENGTH_SHORT).show();
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
