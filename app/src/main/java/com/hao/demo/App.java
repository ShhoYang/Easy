package com.hao.demo;

import android.app.Application;

import com.socks.library.KLog;

/**
 * @author Yang Shihao
 */
public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        KLog.init(true);
    }

    public static App getInstance() {
        return instance;
    }
}
