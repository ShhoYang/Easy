package com.hao.easy.mvvm.user.di.component

import com.hao.easy.mvvm.base.di.component.AppComponent
import com.hao.easy.mvvm.inject.ModuleScope
import com.hao.easy.mvvm.inject.UserAppScope
import com.hao.easy.mvvm.user.UserApp
import com.hao.easy.mvvm.user.di.module.ActivityBuilder
import com.hao.easy.mvvm.user.di.module.FragmentBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


/**
 * @author Yang Shihao
 * @date 2018/12/7
 */

@ModuleScope
@Component(dependencies = [AppComponent::class],
        modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class, FragmentBuilder::class])
interface UserAppComponent : AndroidInjector<UserApp>