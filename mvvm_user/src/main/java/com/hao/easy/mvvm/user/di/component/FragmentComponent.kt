package com.hao.easy.mvvm.user.di.component

import com.hao.easy.mvvm.inject.PreFragment
import com.hao.easy.mvvm.inject.component.AppComponent
import com.hao.easy.mvvm.user.ui.fragment.UserFragment
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreFragment
@Component(dependencies = [AppComponent::class])
interface FragmentComponent {

    fun inject(userFragment: UserFragment)
}