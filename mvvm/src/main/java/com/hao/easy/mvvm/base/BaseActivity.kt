package com.hao.easy.mvvm.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
abstract class BaseActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initView()
}