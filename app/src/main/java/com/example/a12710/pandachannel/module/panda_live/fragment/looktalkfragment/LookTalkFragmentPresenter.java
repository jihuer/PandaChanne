package com.example.a12710.pandachannel.module.panda_live.fragment.looktalkfragment;

import com.example.a12710.pandachannel.model.PandaChannelModelImp;
import com.example.a12710.pandachannel.model.bean.LookTalkBean;
import com.example.a12710.pandachannel.network.MyCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 12710 on 2017/7/20.
 */

public class LookTalkFragmentPresenter implements LookTalkContract.LookTackPresenter{
    private LookTalkContract.LookTackView lookTackView;
    private PandaChannelModelImp pandaChannelModelImp;
    private int p = 0 ;
    public LookTalkFragmentPresenter(LookTalkContract.LookTackView lookTackView, int p) {
        this.lookTackView = lookTackView;
        pandaChannelModelImp = new PandaChannelModelImp();
        this.p = p;

    }

    @Override
    public void start() {
        Map<String,String> map = new HashMap<>();
        map.put("prepage","20");
        map.put("nature","2");
        map.put("app","ipandaApp");
        map.put("page",p+"");
        map.put("itemid","zhiboye_chat");
        pandaChannelModelImp.getPandaLiveLookTalk(map, new MyCallBack<LookTalkBean>() {
            @Override
            public void onSuccess(LookTalkBean lookTalkBean) {
                lookTackView.setResultData(lookTalkBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
