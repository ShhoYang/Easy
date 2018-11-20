package com.hao.easy.mvvm.inject.component

import com.hao.easy.mvvm.inject.ConfigPersistent
import com.hao.easy.mvvm.inject.module.ActivityModule
import com.hao.easy.mvvm.inject.module.FragmentModule
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@ConfigPersistent
@Component(dependencies = [AppComponent::class])
interface ConfigPersistentComponent {

    fun activityComponent(activityModule: ActivityModule): ActivityComponent

    fun fragmentComponent(fragmentModule: FragmentModule): FragmentComponent
}