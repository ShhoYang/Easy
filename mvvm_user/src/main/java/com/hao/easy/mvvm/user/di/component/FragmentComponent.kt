package com.hao.easy.mvvm.user.di.component

import com.hao.easy.mvvm.base.di.component.AppComponent
import com.hao.easy.mvvm.inject.ActivityScope
import com.hao.easy.mvvm.inject.FragmentScope
import com.hao.easy.mvvm.user.ui.activity.LoginActivity
import com.hao.easy.mvvm.user.ui.activity.WelcomeActivity
import com.hao.easy.mvvm.user.ui.fragment.LoginFragment
import com.hao.easy.mvvm.user.ui.fragment.UserFragment
import dagger.Component


/**
 * @author Yang Shihao
 * @date 2018/12/7
 */

@FragmentScope
@Component(dependencies = [AppComponent::class])
interface FragmentComponent {

}