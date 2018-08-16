package com.hao.demo;

import android.app.Application;

import com.socks.library.KLog;

/**
 * @author Yang Shihao
 */
public class App extends Application {
    private static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        KLog.init(true);
    }

    public static App getInstance() {
        return mApp;
    }
}
