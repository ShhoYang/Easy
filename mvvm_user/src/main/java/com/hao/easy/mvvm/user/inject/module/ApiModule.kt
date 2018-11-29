package com.hao.easy.mvvm.user.inject.module

import com.hao.easy.mvvm.user.http.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Yang Shihao
 * @date 2018/11/29
 */
@Module
class ApiModule {

    @Provides
    internal fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}
