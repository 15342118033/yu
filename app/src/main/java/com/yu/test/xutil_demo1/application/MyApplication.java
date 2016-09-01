package com.yu.test.xutil_demo1.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/9/1.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
