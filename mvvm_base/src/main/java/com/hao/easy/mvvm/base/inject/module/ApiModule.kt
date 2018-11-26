package com.hao.easy.mvvm.inject.module

import com.hao.easy.mvvm.base.http.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@Module(includes = [NetworkModule::class])
class ApiModule {

    @Provides
    @Singleton
    internal fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)
}