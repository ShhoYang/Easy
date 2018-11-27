package com.hao.easy.mvvm.inject.module

import android.app.Application
import android.content.Context
import com.hao.easy.mvvm.inject.ApplicationContext
import dagger.Module
import dagger.Provides

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@Module(includes = [NetworkModule::class])
class AppModule(private val application: Application) {

    @Provides
    internal fun provideApplication(): Application = application

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context = application
}