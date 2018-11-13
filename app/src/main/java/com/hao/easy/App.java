package com.hao.easy;

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
        Base.init(this);
    }

    public static App getInstance() {
        return instance;
    }
}
