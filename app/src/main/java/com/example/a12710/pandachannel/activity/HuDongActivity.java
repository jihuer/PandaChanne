package com.example.a12710.pandachannel.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.a12710.pandachannel.Adapter.YuanChuangAdapter;
import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseActivity;
import com.example.a12710.pandachannel.model.bean.YuanChuangbean;
import com.example.a12710.pandachannel.network.HttpUtils;
import com.example.a12710.pandachannel.network.MyCallBack;

import java.util.ArrayList;

/**
 * Created by 魏正洋 on 2017/7/24.
 */

public class HuDongActivity extends BaseActivity {
    private ListView mlist;
    private ImageView mimage;
    private Context context;
    private ArrayList<YuanChuangbean.InteractiveBean> alist = new ArrayList<>();
    private YuanChuangAdapter adapter;
    private String url = "http://www.ipanda.com/kehuduan/PAGE14501767715521482/index.json";
    @Override
    protected void initView() {
        context = HuDongActivity.this;
        mlist = (ListView) findViewById(R.id.yuanchuang_list);
        HttpUtils.getInstance().get(url, null, new MyCallBack<YuanChuangbean>() {

            @Override
            public void onSuccess(YuanChuangbean yuanChuangbean) {
                alist.addAll(yuanChuangbean.getInteractive());
                adapter = new YuanChuangAdapter(alist,context);
                adapter.notifyDataSetChanged();
                mlist.setAdapter(adapter);

                mimage = (ImageView) findViewById(R.id.yuanchuang_back);
                mimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(context,HuDongWeb.class);
                        String ss = alist.get(position).getUrl();
                        String sss = alist.get(position).getTitle();
                        intent.putExtra("haha",sss);
                        intent.putExtra("data",ss);
                        startActivity(intent);


                        finish();
                    }
                });
            }

            @Override
            public void onFaile(String msg) {

            }
        });


    }
    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_yuanchuang;
    }
}
