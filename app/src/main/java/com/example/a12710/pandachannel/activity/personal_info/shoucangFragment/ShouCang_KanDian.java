package com.example.a12710.pandachannel.activity.personal_info.shoucangFragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by dell on 2017/7/22.
 */

public class ShouCang_KanDian extends BaseFragment {

    private ImageView img;
    private ListView listView;
    private ArrayList<String> list;
    private MyListAdapter adapter;


    @Override
    protected void initData() {

       /* SharedPreferences sp = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        String report_img = sp.getString("report_img", "");
        String report_title = sp.getString("report_title", "");
        String time = sp.getString("time", "");
        sp.edit();

        list.add(report_img);
        list.add(report_title);
        list.add(time);
        */
    }

    @Override
    protected void initView(View view) {
        img  = (ImageView) view.findViewById(R.id.kandian_img);
        listView  = (ListView) view.findViewById(R.id.lv_panda_shoucang_zhibo);
        list = new ArrayList<>();


    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_shoucang_kandian;
    }
}
