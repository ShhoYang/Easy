package com.hao.easy.mvvm.inject.component

import android.app.Application
import android.content.Context
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.hao.easy.mvvm.inject.ApplicationContext
import com.hao.easy.mvvm.inject.module.AppModule
import dagger.Component
import okhttp3.Cookie
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun retrofit(): Retrofit

    fun okHttpClient(): OkHttpClient

    fun persistentCookieJar(): PersistentCookieJar

    fun cookies(): List<Cookie>
}