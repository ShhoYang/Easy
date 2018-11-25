package com.hao.easy.mvvm.inject.component

import com.hao.easy.mvvm.ui.activity.MainActivity
import com.hao.easy.mvvm.inject.PreActivity
import com.hao.easy.mvvm.inject.module.ActivityModule
import com.hao.easy.mvvm.ui.activity.LoginActivity
import com.hao.easy.mvvm.ui.activity.WelcomeActivity
import dagger.Subcomponent

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(welcomeActivity: WelcomeActivity)
}