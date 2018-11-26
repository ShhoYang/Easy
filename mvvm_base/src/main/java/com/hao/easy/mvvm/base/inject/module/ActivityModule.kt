package com.hao.easy.mvvm.inject.module

import android.app.Activity
import android.content.Context
import com.hao.easy.mvvm.inject.ActivityContext
import dagger.Module
import dagger.Provides

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    internal fun provideActivity(): Activity {
        return activity
    }

    @Provides
    @ActivityContext
    internal fun provideContext(): Context {
        return activity
    }
}