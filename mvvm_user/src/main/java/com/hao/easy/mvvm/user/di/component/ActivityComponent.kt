package com.hao.easy.mvvm.user.di.component

import com.hao.easy.mvvm.inject.PreActivity
import com.hao.easy.mvvm.inject.component.AppComponent
import com.hao.easy.mvvm.user.ui.activity.MyFavActivity
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreActivity
@Component(dependencies = [AppComponent::class])
interface ActivityComponent {

    fun inject(myFavActivity: MyFavActivity)
}