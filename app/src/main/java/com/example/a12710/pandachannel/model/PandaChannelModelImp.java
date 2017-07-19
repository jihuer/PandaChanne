package com.example.a12710.pandachannel.model;


import com.example.a12710.pandachannel.constants.Urls;
import com.example.a12710.pandachannel.model.bean.BaDaLingBean;
import com.example.a12710.pandachannel.model.bean.HomeDataBean;
import com.example.a12710.pandachannel.model.bean.HomeVideoBean;
import com.example.a12710.pandachannel.model.bean.LiveChinaBean;
import com.example.a12710.pandachannel.model.bean.MultiBean;
import com.example.a12710.pandachannel.model.bean.OriginalBean;
import com.example.a12710.pandachannel.model.bean.PandaBroadBean;
import com.example.a12710.pandachannel.model.bean.PandaBroadTwoBean;
import com.example.a12710.pandachannel.model.bean.PandaLiveBean;
import com.example.a12710.pandachannel.model.bean.RollRollVideoBean;
import com.example.a12710.pandachannel.model.bean.WinderfulBean;
import com.example.a12710.pandachannel.network.HttpFactory;
import com.example.a12710.pandachannel.network.MyCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 11:41
 * 作 者：T
 * 微信：704003376
 */

public class PandaChannelModelImp implements PandaChannelModel {

    @Override
    public void getHomeData(MyCallBack<HomeDataBean> callBack) {
        HttpFactory.create().get(Urls.HOMEURLALL, null, callBack);
    }

    @Override
    public void getRollVideoData(MyCallBack<RollRollVideoBean> callBack) {
        HttpFactory.create().get(Urls.ROLLVIDEO, null, callBack);

    }

    @Override
    public void getLiveData(MyCallBack<LiveChinaBean> callBack) {
        HttpFactory.create().get(Urls.LIVECHINAURL, null, callBack);
    }


    @Override
    public void getPandaBroadData(String path, String primaryId, String serviceId, MyCallBack<PandaBroadBean> callBack) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("path", path);
        params.put("primaryId", primaryId);
        params.put("serviceId", serviceId);
        HttpFactory.create().get(Urls.PANDAREPORT, params, callBack);
    }

    @Override
    public void getPandaBraodData(MyCallBack<PandaBroadTwoBean> callBack) {
        HttpFactory.create().get(Urls.PANDAREPORTTWO, null, callBack);
    }


    @Override
    public void getMultiData(MyCallBack<MultiBean> callBack) {
        HttpFactory.create().get(Urls.MULITANGLE, null, callBack);
    }

    @Override
    public void getHomeVideoData(MyCallBack<HomeVideoBean> callBack) {
        HttpFactory.create().get(Urls.HOMEVIDEOURL, null, callBack);
    }

    @Override
    public void getOriginalData(MyCallBack<OriginalBean> callback) {
        HttpFactory.create().get(Urls.ORIGINAL, null, callback);
    }

    @Override
    public void getBaDaLingData(MyCallBack<BaDaLingBean> callBack) {
        HttpFactory.create().get(Urls.BADALING, null, callBack);
    }


    //TODO  可能有参数
    @Override
    public void getWinderfulData(MyCallBack<WinderfulBean> callBack) {
        Map<String, String> pamrams = new HashMap<String, String>();
        pamrams.put("", "");
        pamrams.put("", "");
        pamrams.put("", "");
        HttpFactory.create().get(Urls.ORIGINALNEWS, pamrams, callBack);
    }
    /**
     *
     * */

    @Override
    public void getPandaLiveData(MyCallBack<PandaLiveBean> callBack) {

        HttpFactory.create().get(Urls.PANDALIVE, null, callBack);
    }

}
