package com.example.a12710.pandachannel.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by 12710 on 2017/7/19.
 */

public class MViewpager extends ViewPager {
    public MViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    public MViewpager(Context context) {
        this(context,null);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        return false;
    }

}
