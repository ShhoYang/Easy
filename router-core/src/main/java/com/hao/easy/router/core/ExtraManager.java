package com.hao.easy.router.core;

import android.app.Activity;
import android.util.LruCache;

import com.hao.easy.router.core.template.IExtra;

/**
 * @author Yang Shihao
 */
public class ExtraManager {
    public static final String SUFFIX_AUTO_WIRED = "_Extra";
    private static ExtraManager instance;
    private LruCache<String, IExtra> mClassCache;

    public static ExtraManager getInstance() {
        if (instance == null) {
            synchronized (ExtraManager.class) {
                if (instance == null) {
                    instance = new ExtraManager();
                }
            }
        }
        return instance;
    }

    public ExtraManager() {
        mClassCache = new LruCache<>(66);
    }

    /**
     * 注入
     */
    public void loadExtra(Activity activity) {
        String className = activity.getClass().getName();
        IExtra iExtra = mClassCache.get(className);
        try {
            if (iExtra == null) {
                iExtra = (IExtra) Class.forName(className + SUFFIX_AUTO_WIRED).getConstructor().newInstance();
            }
            iExtra.loadExtra(activity);
            mClassCache.put(className, iExtra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
