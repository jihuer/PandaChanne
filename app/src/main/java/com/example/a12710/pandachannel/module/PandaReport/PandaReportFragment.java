package com.example.a12710.pandachannel.module.PandaReport;

import android.view.View;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;


public class PandaReportFragment extends BaseFragment implements PandaReportContract.PandaReportView{
   private PandaReportContract.PandaReportPresenter pandaReportPresenter;
    @Override
    public void setPresenter(PandaReportContract.PandaReportPresenter pandaReportPresenter) {
            this.pandaReportPresenter=pandaReportPresenter;
    }
    @Override
    protected void initData() {
        pandaReportPresenter = new PandaReportPresenter(this);
        pandaReportPresenter.start();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_gun_gun;
    }


}
