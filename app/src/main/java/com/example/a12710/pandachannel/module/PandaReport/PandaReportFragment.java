package com.example.a12710.pandachannel.module.PandaReport;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.PandaBroadBean;
import com.example.a12710.pandachannel.module.PandaReport.panda_report.MyPanda_ReportAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;


public class PandaReportFragment extends BaseFragment implements PandaReportContract.PandaReportView{
   private PandaReportContract.PandaReportPresenter pandaReportPresenter;
    private TextView panda_report;
    private XRecyclerView recyclerView;
    private ArrayList<PandaBroadBean.ListBean> listBeen = new ArrayList<>();

    private MyPanda_ReportAdapter adapter;

    String url = "http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/13/1497337653079_517.jpg";
    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter.notifyDataSetChanged();
        }
    };

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
        Log.i("url","initViewinitViewinitViewinitView");
        View view1 =View.inflate(getActivity(),R.layout.panda_report_img,null);
        ImageView iv= (ImageView) view1.findViewById(R.id.image_broad_);
        recyclerView = (XRecyclerView) view.findViewById(R.id.panda_report_recyclerview);
        Glide.with(getActivity()).load(url).into(iv);
        recyclerView.addHeaderView(view1);


        panda_report = (TextView) view.findViewById(R.id.toobar_panda_title);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyPanda_ReportAdapter(getContext(),listBeen);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        panda_report.setText("熊猫播报");
        panda_report.setTextSize(20);
        panda_report.setTextColor(Color.WHITE);


    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_panda_report;
    }


    @Override
    public void setResultData1(PandaBroadBean pandaBroadBean) {
        listBeen.addAll(pandaBroadBean.getList());
        Log.e("TAG",pandaBroadBean.toString());
        handler.sendEmptyMessage(999);
    }
}
