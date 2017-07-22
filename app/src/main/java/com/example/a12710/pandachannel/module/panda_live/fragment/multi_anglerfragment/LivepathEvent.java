package com.example.a12710.pandachannel.module.panda_live.fragment.multi_anglerfragment;

/**
 * Created by 12710 on 2017/7/22.
 */

public class LivepathEvent {
    private String path;
    private String  title;
    public LivepathEvent(String path,String title) {
        this.path = path;
        this.title = title;
    }

    public String getPostation() {
        return title;
    }

    public void setPostation(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
