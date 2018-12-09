package com.hao.easy.mvvm.user.di.module

import dagger.Module
import com.hao.easy.mvvm.user.ui.activity.LoginActivity
import com.hao.easy.mvvm.user.ui.activity.WelcomeActivity
import dagger.android.ContributesAndroidInjector


/**
 * @author Yang Shihao
 * @date 2018/12/7
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    internal abstract fun bindWelcomeActivity(): WelcomeActivity
}