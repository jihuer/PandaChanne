package com.example.a12710.pandachannel.module.live_china;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.ArraySet;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.adpter.CFragmentPagerAdapter;
import com.example.a12710.pandachannel.base.BaseFragment;
import com.example.a12710.pandachannel.model.bean.LiveChinaBean;
import com.example.a12710.pandachannel.module.live_china.live_china_content.LiveChinaFragment;
import com.example.a12710.pandachannel.view.MyGridLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by ASUS on 2017/7/19.
 */

public class LiveChinaFragmentHome extends BaseFragment implements LiveChinaTabContract.LiveChinaTabView, View.OnClickListener {
    LiveChinaTabContract.LiveChinaTabPresenter mliveChinaTabPresenter;
    TabLayout tabLayout;
    ImageView add;
    ViewPager viewPager;
    TextView tou;
    List<Fragment> fragmentList;
    List<String> titleList;
    CFragmentPagerAdapter adapter;

    private PopupWindow mPopupWindow;
    ImageView cha;
    TextView bianji;
    private View viewById;
    MyGridLayout grid1, grid2;
    private List<String> list3;
    private ArrayList<String> list;
    private List<LiveChinaBean.AlllistBean> chinaBeanList;
    boolean sss = false;
    private List<String> list2;

    @Override
    public void setPresenter(LiveChinaTabContract.LiveChinaTabPresenter liveChinaTabPresenter) {
    this.mliveChinaTabPresenter = liveChinaTabPresenter;
    }

    @Override
    protected void initView(View view) {
        tou = (TextView) view.findViewById(R.id.toobar_title);
        tabLayout = (TabLayout) view.findViewById(R.id.lc_tab);
        add = (ImageView) view.findViewById(R.id.lc_add);
        viewPager = (ViewPager) view.findViewById(R.id.lc_vp);
        viewById = view.findViewById(R.id.top_line);

        View popupview = View.inflate(getContext(), R.layout.fragment_livechina_add, null);
        cha = (ImageView) popupview.findViewById(R.id.lc_add_cha);
        bianji = (TextView) popupview.findViewById(R.id.lc_add_bianji);
        grid1 = (MyGridLayout) popupview.findViewById(R.id.grid_one);
        grid2 = (MyGridLayout) popupview.findViewById(R.id.grid_two);
        mPopupWindow = new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.MATCH_PARENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        mPopupWindow.setAnimationStyle(R.style.PopupAnimation);

    }

    @Override
    protected void initData() {
        tou.setText("直播中国");
        mliveChinaTabPresenter = new LiveChinaTabPresenter(this);
        mliveChinaTabPresenter.start();

        list = new ArrayList<>();
        list2 = new ArrayList<>();

        initlistener();
    }


    private void initlistener() {
        add.setOnClickListener(this);
        cha.setOnClickListener(this);
        bianji.setOnClickListener(this);
    }
    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_livechina;
    }

    @Override
    public void setResultData(LiveChinaBean liveChinaBean) {
        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();

        list3 = new ArrayList<>();
        chinaBeanList = new ArrayList<>();
        chinaBeanList.addAll(liveChinaBean.getAlllist());

        for (int i = 0; i <liveChinaBean.getAlllist().size(); i++) {
            list3.add(liveChinaBean.getAlllist().get(i).getTitle());
        }


        if (getContext().getSharedPreferences("data",Context.MODE_PRIVATE).getString("asd","").equals("")){


            for (int i = 0; i <liveChinaBean.getTablist().size(); i++) {

                fragmentList.add(new LiveChinaFragment(liveChinaBean.getTablist().get(i).getUrl()));
                titleList.add(liveChinaBean.getTablist().get(i).getTitle());
            }

        }else {

            Set<String> setlist = new ArraySet<>();
            setlist.addAll(list3);
            titleList.clear();
            Set<String> titleSet = getContext().getSharedPreferences("data", Context.MODE_PRIVATE).getStringSet("slist", setlist);
            titleList.addAll(titleSet);
            fragmentList.clear();
            for (int i = 0; i < titleList.size(); i++) {
                    for (int j = 0; j <chinaBeanList.size(); j++) {
                        if (titleList.get(i).equals(chinaBeanList.get(j).getTitle())) {
                            fragmentList.add(new LiveChinaFragment(chinaBeanList.get(j).getUrl()));
                        }
                    }
            }
        }

        adapter = new CFragmentPagerAdapter(getChildFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        sss =true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lc_add:
                mPopupWindow.showAsDropDown(viewById, 0, 0);
                initpopup();
                break;
            case R.id.lc_add_cha:
                mPopupWindow.dismiss();

                SharedPreferences sp = getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("asd", "2");
                Set<String> set = new ArraySet<String>();
                set.addAll(list);
                editor.putStringSet("slist", set);
                editor.commit();


                if (sss) {
                    if (!getContext().getSharedPreferences("data",Context.MODE_PRIVATE).getString("asd","").equals("")){

                        Set<String> setlist = new ArraySet<>();
                        setlist.addAll(list3);
                        titleList.clear();
                        fragmentList.clear();
                        adapter.notifyDataSetChanged();

                        Set<String> titleSet = getContext().getSharedPreferences("data", Context.MODE_PRIVATE).getStringSet("slist", setlist);
                        titleList.addAll(titleSet);
                        for (int i = 0; i < titleList.size(); i++) {
                                for (int j = 0; j <chinaBeanList.size(); j++) {
                                    if (titleList.get(i).equals(chinaBeanList.get(j).getTitle())) {
                                        fragmentList.add(new LiveChinaFragment(chinaBeanList.get(j).getUrl()));
                                    }
                                }

                        }
                        adapter.notifyDataSetChanged();

                    }
                }
                if (list.size()>0) {
                    list.clear();
                    list2.clear();

                    grid1.removeAllViews();
                    grid2.removeAllViews();
                }

                break;
            case R.id.lc_add_bianji:
                break;
        }
    }

    private void initpopup() {
        //上Gridview 添加item
        grid1.setGridLayoutItemDrageAble(true);

        list.addAll(titleList);
        grid1.addItems(list);

        //下Gridview 添加item
        grid2.setGridLayoutItemDrageAble(false);
        for(String str1 : list3){
            if(!list.contains(str1)){
                // 打印出list2没有b,d
                list2.add(str1);
            }
        }
        grid2.addItems(list2);

        grid1.setOnItemSelectListener(new MyGridLayout.OnItemSelectListener() {
            @Override
            public void onItemSelect(String indexString) {
                Log.d("TuozhuaiActivity", indexString+"");
                list.remove(indexString);
                if (!list2.contains(indexString)){
                    list2.add(indexString);
                    grid2.addTvItem(indexString);
                }


            }
        });
        grid2.setOnItemSelectListener(new MyGridLayout.OnItemSelectListener() {
            @Override
            public void onItemSelect(String indexString) {
                Log.d("TuozhuaiActivity", indexString+"");
                list2.remove(indexString);
                if (!list.contains(indexString)){
                    list.add(indexString);
//                    grid1.addItems(list);
                    grid1.addTvItem(indexString);

                }


            }
        });
    }
}
