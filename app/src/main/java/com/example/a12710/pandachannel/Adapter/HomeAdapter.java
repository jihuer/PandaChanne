package com.example.a12710.pandachannel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a12710.pandachannel.R;
import com.example.a12710.pandachannel.activity.home_activity.BobaoActivity;
import com.example.a12710.pandachannel.activity.home_activity.ChinaliveActivity;
import com.example.a12710.pandachannel.activity.home_activity.GunGunActivity;
import com.example.a12710.pandachannel.activity.home_activity.JIngcaiActivity;
import com.example.a12710.pandachannel.activity.home_activity.XiuchangActivity;
import com.example.a12710.pandachannel.model.bean.HomeDataBean;
import com.example.a12710.pandachannel.model.bean.OriginalBean;
import com.example.a12710.pandachannel.model.bean.RollRollbean;
import com.example.a12710.pandachannel.network.HttpUtils;
import com.example.a12710.pandachannel.network.MyCallBack;
import com.example.a12710.pandachannel.utils.BobaoHolder;
import com.example.a12710.pandachannel.utils.ChinaHolder;
import com.example.a12710.pandachannel.utils.GlideImageLoader;
import com.example.a12710.pandachannel.utils.GunGunHolder;
import com.example.a12710.pandachannel.utils.Home_Url;
import com.example.a12710.pandachannel.utils.JingcaiHolder;
import com.example.a12710.pandachannel.utils.MyGridView;
import com.example.a12710.pandachannel.utils.VpHolder;
import com.example.a12710.pandachannel.utils.ZhiboHoler;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 魏正洋 on 2017/7/23.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final int TYPE_VP = 0;
    private final int BOBAO_VP = 1;
    private final int ZHIBO_VP = 2;
    private final int JINGCAI_VP = 3;
    private final int GUNGUN_VP = 4;
    private final int CHINA_VP = 5;
    private VpHolder vpHolder;
    private BobaoHolder bobaoHolder;
    private ZhiboHoler zhiboHoler;
    private JingcaiHolder jingcaiHolder;
    private GunGunHolder gunGunHolder;
    private ChinaHolder chinaHolder;
    private Context mContext;
    private Banner banner;
    private HomeDataBean homeDataBean;
    private TextView btext1,btext2,btext3,btext4;
    private MyGridView myGridView, myGridView2, myGridView3;
    private ListView mylist1;
    private Boolean aBoolean = true;

    public HomeAdapter(Context mContext, HomeDataBean homeDataBean) {
        this.mContext = mContext;
        this.homeDataBean = homeDataBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_VP){
            View view = LayoutInflater.from(mContext).inflate(R.layout.home_item_banner,parent,false);
            vpHolder = new VpHolder(view);
            banner = (Banner) view.findViewById(R.id.mybanner);
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(mContext, "轮播点击事件" + position, Toast.LENGTH_SHORT).show();
//                    String[] ss = {Home_Url.LUNBOOUT,Home_Url.LUNBOTWO,Home_Url.LUNBOTHREE,Home_Url.LUNBOFOUR};
//                    Intent intent1 = new Intent(mContext, LunboActivity.class);
//                    intent1.putExtra("lunbo",ss[position]);
//                    mContext.startActivity(intent1);
                }
            });
            return vpHolder;
        }
        if (viewType == BOBAO_VP){
            View view = LayoutInflater.from(mContext).inflate(R.layout.home_item_pandareport,parent,false);
            bobaoHolder = new BobaoHolder(view);
            btext1 = (TextView) view.findViewById(R.id.Home_item_Tv_xiari);
            btext2 = (TextView) view.findViewById(R.id.Home_item_Tv_xiaribody);
            btext3 = (TextView) view.findViewById(R.id.Home_item_Tv_shengkuai);
            btext4 = (TextView) view.findViewById(R.id.Home_item_Tv_shengkuaibody);
            //这是熊猫播报的点击
            btext2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"这是第一个点击事件",Toast.LENGTH_SHORT);
                    Intent intent2 = new Intent(mContext, BobaoActivity.class);
                    mContext.startActivity(intent2);

                }
            });
            btext4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"这是第二个点击事件",Toast.LENGTH_SHORT);
                    Intent intent3 = new Intent(mContext,BobaoActivity.class);
                    mContext.startActivity(intent3);
                }
            });
            return bobaoHolder;
        }
        if (viewType == ZHIBO_VP){
            View view = LayoutInflater.from(mContext).inflate(R.layout.home_item_liveshow,parent,false);
            zhiboHoler = new ZhiboHoler(view);
            myGridView = (MyGridView) view.findViewById(R.id.Home_item_gridview);
            myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    position = position + 1;
                    List<String> list = new ArrayList<String>();
                    list.add(Home_Url.ZHIBO1);
                    list.add(Home_Url.ZHIBO2);
                    list.add(Home_Url.ZHIBO3);
                    list.add(Home_Url.ZHIBO4);
                    list.add(Home_Url.ZHIBO5);
                    list.add(Home_Url.ZHIBO6);
                    list.add(Home_Url.ZHIBO7);
                    list.add(Home_Url.ZHIBO8);
                    list.add(Home_Url.ZHIBO9);
                    Intent intent4 = new Intent(mContext, XiuchangActivity.class);
                    intent4.putExtra("xiuchang",list.get(position));
                    mContext.startActivity(intent4);
                    Toast.makeText(mContext,"这是熊猫秀场点击事件",Toast.LENGTH_SHORT);
                }
            });
            return zhiboHoler;
        }
        if (viewType == JINGCAI_VP){
            View view = LayoutInflater.from(mContext).inflate(R.layout.home_item_amazing,parent,false);
            jingcaiHolder = new JingcaiHolder(view);
            myGridView2 = (MyGridView) view.findViewById(R.id.Home_GridView_Amazing);
            myGridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String[] ss = {Home_Url.JINGCAI1,Home_Url.JINGCAI2,Home_Url.JINGCAI3,Home_Url.JINGCAI4};
                    Toast.makeText(mContext,"这是精彩推荐点击事件",Toast.LENGTH_SHORT);
                    Intent intent5 = new Intent(mContext, JIngcaiActivity.class);
                    intent5.putExtra("jingcai",ss[position]);
                    mContext.startActivity(intent5);
                }
            });
            return jingcaiHolder;
        }
        if (viewType == GUNGUN_VP){
            View view = LayoutInflater.from(mContext).inflate(R.layout.home_item_rollingvideo,parent,false);
            gunGunHolder = new GunGunHolder(view);
            mylist1 = (ListView) view.findViewById(R.id.Home_item_RollongVideo_ListView);
            mylist1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext,"这是滚滚视频点击事件",Toast.LENGTH_SHORT);
                    String[] ss = {Home_Url.GUNGUN1,Home_Url.GUNGUN2,Home_Url.GUNGUN3,Home_Url.GUNGUN4,Home_Url.GUNGUN5};
                    Intent intent6 = new Intent(mContext, GunGunActivity.class);
                    intent6.putExtra("gun",ss[position]);
                    mContext.startActivity(intent6);
                }
            });
            return gunGunHolder;

        }
        if (viewType == CHINA_VP){
            View view = LayoutInflater.from(mContext).inflate(R.layout.home_item_livechian,parent,false);
            chinaHolder = new ChinaHolder(view);
            myGridView3 = (MyGridView) view.findViewById(R.id.Home_chinaitem_GridView);
            myGridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext,"这是直播中国点击事件",Toast.LENGTH_SHORT);
                    String[] ss = {Home_Url.CHINA1,Home_Url.CHINA2,Home_Url.CHINA3,Home_Url.CHINA4,Home_Url.CHINA5,Home_Url.CHINA6,Home_Url.CHINA7,Home_Url.CHINA8,Home_Url.CHINA9,};
                    Intent intent7 = new Intent(mContext, ChinaliveActivity.class);
                    intent7.putExtra("zxlive",ss[position]);
                    mContext.startActivity(intent7);
                }
            });
            return chinaHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == TYPE_VP){

            HttpUtils.getInstance().get("http://www.ipanda.com/kehuduan/shouye/index.json", null, new MyCallBack<HomeDataBean>() {
                @Override
                public void onSuccess(HomeDataBean homeDataBean) {
                    List<String> imaglist = new ArrayList<>();
                    imaglist.add(homeDataBean.getData().getBigImg().get(0).getImage());
                    imaglist.add(homeDataBean.getData().getBigImg().get(1).getImage());
                    imaglist.add(homeDataBean.getData().getBigImg().get(2).getImage());
                    imaglist.add(homeDataBean.getData().getBigImg().get(3).getImage());

                    List<String> textlist = new ArrayList<>();
                    textlist.add(homeDataBean.getData().getBigImg().get(0).getTitle());
                    textlist.add(homeDataBean.getData().getBigImg().get(1).getTitle());
                    textlist.add(homeDataBean.getData().getBigImg().get(2).getTitle());
                    textlist.add(homeDataBean.getData().getBigImg().get(3).getTitle());
                    banner.update(imaglist, textlist);
                    banner.isAutoPlay(true);
                    banner.setImageLoader(new GlideImageLoader());
                    banner.setDelayTime(3000);
                    banner.setIndicatorGravity(BannerConfig.LEFT);
                    banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                    banner.start();
                }

                @Override
                public void onFaile(String msg) {

                }
            });
            Log.e("我的打印","哈哈");

        }
        if (position == BOBAO_VP){
            HttpUtils.getInstance().get("http://www.ipanda.com/kehuduan/shouye/index.json", null, new MyCallBack<HomeDataBean>() {
                @Override
                public void onSuccess(HomeDataBean homedatabean) {
                    btext1.setText(homedatabean.getData().getPandaeye().getItems().get(0).getBrief());
                    btext2.setText(homedatabean.getData().getPandaeye().getItems().get(0).getTitle());
                    btext3.setText(homedatabean.getData().getPandaeye().getItems().get(1).getBrief());
                    btext4.setText(homedatabean.getData().getPandaeye().getItems().get(1).getTitle());
                }

                @Override
                public void onFaile(String msg) {

                }
            });

        }
        if (aBoolean){
            if(position == ZHIBO_VP){
                HttpUtils.getInstance().get("http://www.ipanda.com/kehuduan/shouye/index.json", null, new MyCallBack<HomeDataBean>() {
                    @Override
                    public void onSuccess(HomeDataBean listBean) {
                        ArrayList<HomeDataBean.DataBean.PandaliveBean.ListBean> alist = new ArrayList<>();
                        alist.addAll(listBean.getData().getPandalive().getList());
                        ZXAdapter zxAdapter = new ZXAdapter(mContext,alist);
                        myGridView.setAdapter(zxAdapter);
                        aBoolean = false;
                    }

                    @Override
                    public void onFaile(String msg) {

                    }
                });

            }
        }
        if (position == JINGCAI_VP){
            HttpUtils.getInstance().get("http://www.ipanda.com/kehuduan/shipinliebieye/jingcaiyike/index.json", null, new MyCallBack<OriginalBean>() {
                @Override
                public void onSuccess(OriginalBean originalBean) {
                    ArrayList<OriginalBean.ListBean> alsit1 = new ArrayList<OriginalBean.ListBean>();
                    alsit1.addAll(originalBean.getList());
                    JCAdapter jcadapter = new JCAdapter(mContext,alsit1);
                    myGridView2.setAdapter(jcadapter);
                }

                @Override
                public void onFaile(String msg) {

                }
            });
        }
        if (position == GUNGUN_VP){
            HttpUtils.getInstance().get("http://www.ipanda.com/kehuduan/shipinliebieye/video/index.json", null, new MyCallBack<RollRollbean>() {
                @Override
                public void onSuccess(RollRollbean rollRollVideoBean) {
                    ArrayList<RollRollbean.ListBean> alist2 = new ArrayList<RollRollbean.ListBean>();
                    for (int i = 0; i < rollRollVideoBean.getList().size(); i++) {
                        alist2.addAll(rollRollVideoBean.getList());
                    }
                    GGAdapter adapter = new GGAdapter(mContext,alist2);
                    mylist1.setAdapter(adapter);
                }

                @Override
                public void onFaile(String msg) {

                }
            });
        }
        if (position == CHINA_VP){
            HttpUtils.getInstance().get("http://www.ipanda.com/kehuduan/shouye/index.json", null, new MyCallBack<HomeDataBean>() {


                @Override
                public void onSuccess(HomeDataBean homeDataBean) {
                    ArrayList<HomeDataBean.DataBean.ChinaliveBean.ListBeanX> alist3 = new ArrayList<>();
                    alist3.addAll(homeDataBean.getData().getChinalive().getList());
                    ZZAdapter adapter = new ZZAdapter(mContext,alist3);
                    myGridView3.setAdapter(adapter);
                }

                @Override
                public void onFaile(String msg) {

                }
            });

        }
    }
    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return TYPE_VP;
        }
        if (position == 1) {
            return BOBAO_VP;
        }
        if (position == 2) {
            return ZHIBO_VP;
        }
        if (position == 3) {
            return JINGCAI_VP;
        }
        if (position == 4) {
            return GUNGUN_VP;
        }
        if (position == 5) {
            return CHINA_VP;
        }
        return super.getItemViewType(position);
    }
    @Override
    public int getItemCount() {
        return 6;
    }
}
