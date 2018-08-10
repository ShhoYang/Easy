package com.hao.demo.test;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Yang Shihao
 */
public class SharePreferenceDao {

    private SharedPreferences mSp;

    public SharePreferenceDao(Context context) {
        this(context.getSharedPreferences("config", Context.MODE_PRIVATE));
    }

    public SharePreferenceDao(SharedPreferences sp) {
        mSp = sp;
    }

    public void put(String key, String value) {
        SharedPreferences.Editor edit = mSp.edit();
        edit.putString(key, value);
        edit.apply();
    }

    public String get(String key) {
        return mSp.getString(key, "");
    }
}
