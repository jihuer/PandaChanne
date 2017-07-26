package com.example.a12710.pandachannel.module.PandaReport;

import android.content.Intent;
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
import com.example.a12710.pandachannel.activity.personal_info.Panda_image_video_Activity;
import com.example.a12710.pandachannel.activity.personal_info.PersonInfoActivity;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.PandaBroadBean;
import com.example.a12710.pandachannel.model.bean.PandaBroadTwoBean;
import com.example.a12710.pandachannel.module.PandaReport.panda_report.MyPanda_ReportAdapter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class PandaReportFragment extends BaseFragment implements PandaReportContract.PandaReportView{
   private PandaReportContract.PandaReportPresenter pandaReportPresenter;
    private TextView panda_report;
    private XRecyclerView recyclerView;
    private ArrayList<PandaBroadBean.ListBean> listBeen = new ArrayList<>();
    private ArrayList<PandaBroadTwoBean.DataBean.BigImgBean> list = new ArrayList<>();
    private int page = 1;
    private MyPanda_ReportAdapter adapter;


    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter.notifyDataSetChanged();
        }
    };
    private ImageView imageView;

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

        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable(){
                    public void run() {

                        adapter.notifyDataSetChanged();
                        recyclerView.refreshComplete();
                    }

                }, 2000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        page++;
                        initNet();
                        adapter.notifyDataSetChanged();
                        recyclerView.loadMoreComplete();
                    }
                }, 1500);
            }
        });
    }

    @Override
    protected void initView(View view) {
        initNet();
        Log.i("url","initViewinitViewinitViewinitView");

        recyclerView = (XRecyclerView) view.findViewById(R.id.panda_report_recyclerview);

        panda_report = (TextView) view.findViewById(R.id.toobar_panda_title);
        imageView = (ImageView) view.findViewById(R.id.toobar_sign);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonInfoActivity.class);
                getActivity().startActivity(intent);
            }
        });
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

    private void initNet() {
        new Thread(){
            @Override
            public void run() {
                super.run();

                String url = "http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda&pageSize=6&page="+page;
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(url).build();
                try {
                    Response response = client.newCall(request).execute();
                    String str = response.body().string();
                    Gson gson = new Gson();
                    PandaBroadBean pan = gson.fromJson(str,PandaBroadBean.class);
                    listBeen.addAll(pan.getList());
                    handler.sendEmptyMessage(999);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_panda_report;
    }


    @Override
    public void setResultData(PandaBroadTwoBean pandaBroadTwoBean) {
        list.addAll(pandaBroadTwoBean.getData().getBigImg());
        View view1 =View.inflate(getActivity(),R.layout.panda_report_img,null);
        ImageView iv= (ImageView) view1.findViewById(R.id.image_broad_);
        TextView tv = (TextView) view1.findViewById(R.id.panda_title);
        Glide.with(getActivity()).load(pandaBroadTwoBean.getData().getBigImg().get(0).getImage()).into(iv);
        tv.setText(pandaBroadTwoBean.getData().getBigImg().get(0).getTitle());
        recyclerView.addHeaderView(view1);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Panda_image_video_Activity.class);
                Log.e("TAG----",list.get(0).getUrl());
                intent.putExtra("url",list.get(0).getUrl());
                getActivity().startActivity(intent);
            }
        });

    }

   /* @Override
    public void setResultData1(PandaBroadBean pandaBroadBean) {
        listBeen.addAll(pandaBroadBean.getList());
        Log.e("TAG",pandaBroadBean.toString());
        handler.sendEmptyMessage(999);
    }*/
}
