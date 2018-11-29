package com.hao.easy.mvvm.user.inject.component

import com.hao.easy.mvvm.inject.PreApp
import com.hao.easy.mvvm.inject.component.AppComponent
import com.hao.easy.mvvm.user.http.Api
import com.hao.easy.mvvm.user.inject.module.ApiModule
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/11/29
 */
@PreApp
@Component(modules = [ApiModule::class] ,dependencies = [AppComponent::class])
interface ApiComponent {
    fun api(): Api
}
