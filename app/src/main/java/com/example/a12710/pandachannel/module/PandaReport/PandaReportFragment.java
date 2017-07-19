package com.example.pandachannel.module.PandaReport;

import android.view.View;

import com.example.pandachannel.base.BaseFragment;


public class PandaReportFragment extends BaseFragment implements PandaReportContract.PandaReportView{
   private PandaReportContract.PandaReportPresenter pandaReportPresenter;
    @Override
    public void setPresenter(PandaReportContract.PandaReportPresenter pandaReportPresenter) {
            this.pandaReportPresenter=pandaReportPresenter;
    }
    @Override
    protected void initData() {
        pandaReportPresenter.start();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public int getFragmentLayoutId() {
        return 0;
    }


}
