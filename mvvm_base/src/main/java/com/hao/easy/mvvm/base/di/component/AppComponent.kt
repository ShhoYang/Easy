package com.hao.easy.mvvm.base.di.component

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.inject.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import okhttp3.Cookie
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Yang Shihao
 * @date 2018/12/7
 */

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : AndroidInjector<App> {

    fun retrofit(): Retrofit

    fun okHttpClient(): OkHttpClient

    fun persistentCookieJar(): PersistentCookieJar

    fun cookies(): List<Cookie>
}
