package com.hao.easy.mvvm.user

import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.user.inject.component.DaggerApiComponent
import com.hao.easy.mvvm.user.inject.module.ApiModule

/**
 * @author Yang Shihao
 * @date 2018/11/29
 */
object UserApp {

    val apiComponent =
            DaggerApiComponent.builder()
                    .appComponent(App.instance.appComponent)
                    .apiModule(ApiModule())
                    .build()
}