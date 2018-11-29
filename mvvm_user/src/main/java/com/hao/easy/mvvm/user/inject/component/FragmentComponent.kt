package com.hao.easy.mvvm.user.inject.component

import com.hao.easy.mvvm.inject.PreFragment
import com.hao.easy.mvvm.inject.component.AppComponent
import com.hao.easy.mvvm.user.inject.module.FragmentModule
import com.hao.easy.mvvm.user.ui.fragment.LoginFragment
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreFragment
@Component(modules = [FragmentModule::class], dependencies = [ApiComponent::class])
interface FragmentComponent {

    fun inject(loginFragment: LoginFragment)

}