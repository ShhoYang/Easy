package com.hao.easy.mvvm.user.inject.component

import com.hao.easy.mvvm.inject.PreActivity
import com.hao.easy.mvvm.inject.component.AppComponent
import com.hao.easy.mvvm.user.ui.activity.WelcomeActivity
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreActivity
@Component(dependencies = [AppComponent::class])
interface ActivityComponent {

    fun inject(welcomeActivity: WelcomeActivity)

}