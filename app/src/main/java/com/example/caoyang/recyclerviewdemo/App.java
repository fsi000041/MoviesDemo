package com.example.caoyang.recyclerviewdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by caoyang on 2017/7/11.
 */

public class App extends Application {
    static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();

    }
    public static Context getContext() {
        return sContext;
    }
}
