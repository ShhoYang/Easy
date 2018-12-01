package com.hao.easy.mvvm.android.di.component

import com.hao.easy.mvvm.android.di.module.FragmentModule
import com.hao.easy.mvvm.android.ui.fragment.AndroidFragment
import com.hao.easy.mvvm.inject.PreFragment
import com.hao.easy.mvvm.inject.component.AppComponent
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreFragment
@Component(modules = [FragmentModule::class], dependencies = [AppComponent::class])
interface FragmentComponent {

    fun inject(articleFragment: AndroidFragment)
}