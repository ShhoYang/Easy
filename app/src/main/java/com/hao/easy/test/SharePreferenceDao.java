package com.hao.easy.test;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Yang Shihao
 */
public class SharePreferenceDao {

    private SharedPreferences sp;

    public SharePreferenceDao(Context context) {
        this(context.getSharedPreferences("config", Context.MODE_PRIVATE));
    }

    public SharePreferenceDao(SharedPreferences sp) {
        sp = sp;
    }

    public void put(String key, String value) {
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
        edit.apply();
    }

    public String get(String key) {
        return sp.getString(key, "");
    }
}
