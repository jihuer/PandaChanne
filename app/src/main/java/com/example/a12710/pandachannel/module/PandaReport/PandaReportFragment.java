package com.example.a12710.pandachannel.module.PandaReport;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.PandaBroadTwoBean;
import com.example.a12710.pandachannel.module.panda_report.MyPanda_ReportAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;


public class PandaReportFragment extends BaseFragment implements PandaReportContract.PandaReportView{
   private PandaReportContract.PandaReportPresenter pandaReportPresenter;
    private TextView panda_report;
    private XRecyclerView recyclerView;
    private ArrayList<PandaBroadTwoBean.ListBean> listBeen;
    private MyPanda_ReportAdapter adapter;


    @Override
    public void setPresenter(PandaReportContract.PandaReportPresenter pandaReportPresenter) {
            this.pandaReportPresenter=pandaReportPresenter;
    }
    @Override
    protected void initData() {
        pandaReportPresenter = new PandaReportPresenter(this);
        pandaReportPresenter.start();

        adapter = new MyPanda_ReportAdapter(getContext(),listBeen);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void initView(View view) {
        panda_report = (TextView) view.findViewById(R.id.toobar_panda_title);
        recyclerView = (XRecyclerView) view.findViewById(R.id.panda_report_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        panda_report.setText("熊猫播报");
        panda_report.setTextSize(20);
        panda_report.setTextColor(Color.WHITE);
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_panda_report;
    }

    @Override
    public void setResultData(PandaBroadTwoBean pandaBroadTwoBean) {
        listBeen.addAll(pandaBroadTwoBean.getList());
    }
}
