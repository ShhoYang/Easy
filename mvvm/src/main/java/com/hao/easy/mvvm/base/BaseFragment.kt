package com.hao.easy.mvvm.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hao.easy.mvvm.common.App
import com.hao.easy.mvvm.inject.component.ActivityComponent
import com.hao.easy.mvvm.inject.component.DaggerConfigPersistentComponent
import com.hao.easy.mvvm.inject.component.FragmentComponent
import com.hao.easy.mvvm.inject.module.FragmentModule

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
abstract class BaseFragment : Fragment() {

    private var fragmentComponent: FragmentComponent? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        initInject()
        initView()
        initData()
    }

    private fun init() {
        val configPersistentComponent = DaggerConfigPersistentComponent.builder()
                .appComponent(App.instance.appComponent)
        fragmentComponent = configPersistentComponent.build().fragmentComponent(FragmentModule(this))

    }

    fun fragmentComponent() = fragmentComponent!!

    @LayoutRes
    abstract fun getLayoutId(): Int

    open fun initInject() {
    }

    open fun initView() {

    }

    open fun initData() {

    }


}