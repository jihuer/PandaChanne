package com.example.a12710.pandachannel.global;

import android.app.Application;

import com.example.a12710.pandachannel.base.BaseActivity;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;


/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 09:28
 * 作 者：T
 * 微信：704003376
 */

public class MyApp extends Application {
    public static BaseActivity mContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
    }

    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
}
