package com.hao.easy.mvvm.user.di.module

import com.hao.easy.mvvm.user.ui.fragment.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * @author Yang Shihao
 * @date 2018/12/7
 */

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindLoginFragment(): LoginFragment
}