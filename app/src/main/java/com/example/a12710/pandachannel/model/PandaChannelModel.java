package com.example.a12710.pandachannel.model;

import com.example.a12710.pandachannel.model.bean.BaDaLingBean;
import com.example.a12710.pandachannel.model.bean.HomeDataBean;
import com.example.a12710.pandachannel.model.bean.HomeVideoBean;
import com.example.a12710.pandachannel.model.bean.LiveChinaBean;
import com.example.a12710.pandachannel.model.bean.LiveChinaContentBean;
import com.example.a12710.pandachannel.model.bean.MultiBean;
import com.example.a12710.pandachannel.model.bean.OriginalBean;
import com.example.a12710.pandachannel.model.bean.PandaBroadBean;
import com.example.a12710.pandachannel.model.bean.PandaBroadTwoBean;
import com.example.a12710.pandachannel.model.bean.PandaLiveBean;
import com.example.a12710.pandachannel.model.bean.RollRollVideoBean;
import com.example.a12710.pandachannel.model.bean.WinderfulBean;
import com.example.a12710.pandachannel.network.MyCallBack;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 11:27
 * 作 者：T
 * 微信：704003376
 *
 * 请求各个模块数据
 */

public interface PandaChannelModel {

    /**
     * 首页数据
     * @param callBack
     */
    void getHomeData(MyCallBack<HomeDataBean> callBack);

    /**
     * 滚滚视频数据
     *
     * @param callBack
     */
    void getRollVideoData(MyCallBack<RollRollVideoBean> callBack);


    /**
     * 获取直播中国数据
     *
     * @param callBack
     */
    void getLiveData(String url,MyCallBack<LiveChinaContentBean> callBack);
    void getLiveTabData(MyCallBack<LiveChinaBean> callBack);


    /**
     * 熊猫播报1(请求URL中有参数的)
     * @param path
     * @param primaryId
     * @param serviceId
     * @param callBack
     */
    void getPandaBroadData(String path, String primaryId,
                           String serviceId, MyCallBack<PandaBroadBean> callBack);

    /**
     * 熊猫播报2（请求URL中没有参数）
     * @param callBack
     */
    void getPandaBraodData(MyCallBack<PandaBroadTwoBean> callBack);


    /**
     * 获取多角度数据
     * @param callBack
     */
    void getMultiData(MyCallBack<MultiBean> callBack);


    /**
     * 获取首页视频
     * @param callBack
     */
    void getHomeVideoData(MyCallBack<HomeVideoBean> callBack);


    /**
     * 获取原创互动
     * @param callback
     */
    void getOriginalData(MyCallBack<OriginalBean> callback);


    /**
     * 获取八达岭数据
     * @param callBack
     */
    void getBaDaLingData(MyCallBack<BaDaLingBean> callBack);


    /**
     * 获取精彩一刻数据
     * @param callBack
     */
    void getWinderfulData(MyCallBack<WinderfulBean> callBack);
    /**
     * 获取熊猫直播数据
     * @param callBack
     */
    void getPandaLiveData(MyCallBack<PandaLiveBean> callBack);
}
