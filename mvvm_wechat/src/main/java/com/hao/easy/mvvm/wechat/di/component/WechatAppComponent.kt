package com.hao.easy.mvvm.wechat.di.component

import com.hao.easy.mvvm.base.di.component.AppComponent
import com.hao.easy.mvvm.inject.ModuleScope
import com.hao.easy.mvvm.wechat.WechatApp
import com.hao.easy.mvvm.wechat.di.module.ActivityBuilder2
import com.hao.easy.mvvm.wechat.di.module.FragmentBuilder2
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


/**
 * @author Yang Shihao
 * @date 2018/12/7
 */

@ModuleScope
@Component(dependencies = [AppComponent::class],
        modules = [AndroidSupportInjectionModule::class])
interface WechatAppComponent : AndroidInjector<WechatApp>