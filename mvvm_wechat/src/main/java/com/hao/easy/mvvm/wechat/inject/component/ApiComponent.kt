package com.hao.easy.mvvm.wechat.inject.component

import com.hao.easy.mvvm.inject.module.ApiModule
import com.hao.easy.mvvm.wechat.http.Api
import dagger.Subcomponent
import javax.inject.Singleton

/**
 * @author Yang Shihao
 * @date 2018/11/27
 */
@Singleton
@Subcomponent(modules = [ApiModule::class])
interface ApiComponent {
    fun api(): Api
}