package com.hao.easy.mvvm.base.ui

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.common.App
import com.hao.easy.mvvm.inject.component.DaggerConfigPersistentComponent
import com.hao.easy.mvvm.inject.module.FragmentModule
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
        setContentView(getLayoutId())
        onInit()
        initInject()
        initView()
        initData()
    }

    open fun onInit() {
        val configPersistentComponent = DaggerConfigPersistentComponent.builder()
                .appComponent(App.instance.appComponent)

    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    open fun initInject() {
    }

    open fun initView() {

    }

    open fun initData() {

    }
}