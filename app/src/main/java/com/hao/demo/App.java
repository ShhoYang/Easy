package com.hao.demo;

import android.app.Application;

/**
 * @author Yang Shihao
 */
public class App extends Application {
    private static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }

    public static App getInstance() {
        return mApp;
    }
}
