package com.hao.easy.router.core;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;

import com.hao.easy.router.annotation.modle.RouteMeta;
import com.hao.easy.router.core.callback.NavigationCallback;
import com.hao.easy.router.core.template.IService;

import java.util.ArrayList;

/**
 * @author Yang Shihao
 */
public class Postcard extends RouteMeta {

    private Bundle mBundle;
    private int mFlags = -1;

    private Bundle mOptionsCompat;
    private int mEnterAnim;
    private int mExitAnim;

    //服务
    private IService mService;

    public Postcard(String path, String group) {
        this(path, group, null);
    }

    public Postcard(String path, String group, Bundle bundle) {
        setPath(path);
        setGroup(group);
        mBundle = bundle == null ? new Bundle() : bundle;
    }

    public Bundle getExtras() {
        return mBundle;
    }

    public Bundle getOptionsCompat() {
        return mOptionsCompat;
    }

    public void setOptionsCompat(Bundle optionsCompat) {
        mOptionsCompat = optionsCompat;
    }

    public int getEnterAnim() {
        return mEnterAnim;
    }

    public void setEnterAnim(int enterAnim) {
        mEnterAnim = enterAnim;
    }

    public int getExitAnim() {
        return mExitAnim;
    }

    public void setExitAnim(int exitAnim) {
        mExitAnim = exitAnim;
    }

    public IService getService() {
        return mService;
    }

    public void setService(IService service) {
        mService = service;
    }

    public int getFlags() {
        return mFlags;
    }

    public Postcard withFlags(int flags) {
        mFlags = flags;
        return this;
    }

    public Postcard withTransition(int enterAnim, int exitAnim) {
        mEnterAnim = enterAnim;
        mExitAnim = exitAnim;
        return this;
    }

    public Postcard withOptionsCompat(ActivityOptionsCompat compat) {
        if (compat != null) {
            mOptionsCompat = compat.toBundle();
        }
        return this;
    }

    public Postcard withString(@Nullable String key, @Nullable String value) {
        mBundle.putString(key, value);
        return this;
    }


    public Postcard withBoolean(@Nullable String key, boolean value) {
        mBundle.putBoolean(key, value);
        return this;
    }


    public Postcard withShort(@Nullable String key, short value) {
        mBundle.putShort(key, value);
        return this;
    }


    public Postcard withInt(@Nullable String key, int value) {
        mBundle.putInt(key, value);
        return this;
    }


    public Postcard withLong(@Nullable String key, long value) {
        mBundle.putLong(key, value);
        return this;
    }


    public Postcard withDouble(@Nullable String key, double value) {
        mBundle.putDouble(key, value);
        return this;
    }


    public Postcard withByte(@Nullable String key, byte value) {
        mBundle.putByte(key, value);
        return this;
    }


    public Postcard withChar(@Nullable String key, char value) {
        mBundle.putChar(key, value);
        return this;
    }


    public Postcard withFloat(@Nullable String key, float value) {
        mBundle.putFloat(key, value);
        return this;
    }


    public Postcard withParcelable(@Nullable String key, @Nullable Parcelable value) {
        mBundle.putParcelable(key, value);
        return this;
    }


    public Postcard withStringArray(@Nullable String key, @Nullable String[] value) {
        mBundle.putStringArray(key, value);
        return this;
    }


    public Postcard withBooleanArray(@Nullable String key, boolean[] value) {
        mBundle.putBooleanArray(key, value);
        return this;
    }


    public Postcard withShortArray(@Nullable String key, short[] value) {
        mBundle.putShortArray(key, value);
        return this;
    }


    public Postcard withIntArray(@Nullable String key, int[] value) {
        mBundle.putIntArray(key, value);
        return this;
    }


    public Postcard withLongArray(@Nullable String key, long[] value) {
        mBundle.putLongArray(key, value);
        return this;
    }


    public Postcard withDoubleArray(@Nullable String key, double[] value) {
        mBundle.putDoubleArray(key, value);
        return this;
    }


    public Postcard withByteArray(@Nullable String key, byte[] value) {
        mBundle.putByteArray(key, value);
        return this;
    }


    public Postcard withCharArray(@Nullable String key, char[] value) {
        mBundle.putCharArray(key, value);
        return this;
    }


    public Postcard withFloatArray(@Nullable String key, float[] value) {
        mBundle.putFloatArray(key, value);
        return this;
    }


    public Postcard withParcelableArray(@Nullable String key, @Nullable Parcelable[] value) {
        mBundle.putParcelableArray(key, value);
        return this;
    }

    public Postcard withParcelableArrayList(@Nullable String key, @Nullable ArrayList<? extends
            Parcelable> value) {
        mBundle.putParcelableArrayList(key, value);
        return this;
    }

    public Postcard withIntegerArrayList(@Nullable String key, @Nullable ArrayList<Integer> value) {
        mBundle.putIntegerArrayList(key, value);
        return this;
    }

    public Postcard withStringArrayList(@Nullable String key, @Nullable ArrayList<String> value) {
        mBundle.putStringArrayList(key, value);
        return this;
    }

    public Object navigation() {
        return Router.getInstance().navigation(null, this, -1, null);
    }

    public Object navigation(Context context) {
        return Router.getInstance().navigation(context, this, -1, null);
    }


    public Object navigation(Context context, NavigationCallback callback) {
        return Router.getInstance().navigation(context, this, -1, callback);
    }

    public Object navigation(Context context, int requestCode) {
        return Router.getInstance().navigation(context, this, requestCode, null);
    }

    public Object navigation(Context context, int requestCode, NavigationCallback callback) {
        return Router.getInstance().navigation(context, this, requestCode, callback);
    }
}
