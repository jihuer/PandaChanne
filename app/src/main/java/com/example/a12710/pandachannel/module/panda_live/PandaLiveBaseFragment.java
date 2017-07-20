package com.example.a12710.pandachannel.module.panda_live;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;

/**
 * Created by 12710 on 2017/7/20.
 */

public class PandaLiveBaseFragment extends BaseFragment {
    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        Toast.makeText(getActivity(), arguments.getString("vsid")+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_looktack;
    }
}
