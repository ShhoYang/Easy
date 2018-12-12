package com.hao.easy.mvvm.user.di.component

import com.hao.easy.mvvm.base.di.component.AppComponent
import com.hao.easy.mvvm.inject.ActivityScope
import com.hao.easy.mvvm.user.ui.activity.WelcomeActivity
import dagger.Component


/**
 * @author Yang Shihao
 * @date 2018/12/7
 */

@ActivityScope
@Component(dependencies = [AppComponent::class])
interface ActivityComponent {

}