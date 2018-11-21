package com.hao.easy.mvvm.base.ui

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.hao.easy.mvvm.R
import com.noober.background.BackgroundLibrary
import kotlinx.android.synthetic.main.activity_base.*

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        BackgroundLibrary.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        View.inflate(this, getLayoutId(), activityRootView)

        initView()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initView()
}