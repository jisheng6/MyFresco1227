package com.bwei.myfresco1227.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/27 9:17
 */
public class MyAppliction extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
