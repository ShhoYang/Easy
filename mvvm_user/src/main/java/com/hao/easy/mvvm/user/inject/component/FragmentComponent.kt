package com.hao.easy.mvvm.user.inject.component

import com.hao.easy.mvvm.inject.PreFragment
import com.hao.easy.mvvm.user.ui.fragment.LoginFragment
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreFragment
@Component()
interface FragmentComponent {

    fun inject(loginFragment: LoginFragment)

}