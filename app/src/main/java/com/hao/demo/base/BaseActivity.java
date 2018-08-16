package com.hao.demo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hao.demo.utils.T;
import com.socks.library.KLog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Yang Shihao
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Unbinder mUnbinder;
    protected String TAG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        TAG = getClass().getSimpleName();
        KLog.d(TAG, "onCreate: " + TAG);
        setTitle(TAG);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }


    protected abstract @LayoutRes
    int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected void toast(String s) {
        T.showShort(this, s);
    }

    protected void startActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
