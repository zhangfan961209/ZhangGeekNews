package com.example.zhangfan.outgeeknews.base;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;




public class BaseApp extends Application {
    private static BaseApp sBaseApp;
    //默认不是夜间模式
    public static int mMode = AppCompatDelegate.MODE_NIGHT_NO;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;
    }

    public static BaseApp getInstance(){
        return sBaseApp;
    }

}
