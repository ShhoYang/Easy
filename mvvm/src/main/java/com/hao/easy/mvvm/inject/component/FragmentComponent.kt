package com.hao.easy.mvvm.inject.component

import com.hao.easy.mvvm.first.ui.fragment.FirstFragment
import com.hao.easy.mvvm.inject.PreFragment
import com.hao.easy.mvvm.inject.module.FragmentModule
import dagger.Subcomponent

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreFragment
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(firstFragment: FirstFragment)
}