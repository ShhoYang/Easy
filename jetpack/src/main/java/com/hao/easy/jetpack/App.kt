package com.hao.easy.jetpack

import android.app.Application

/**
 * @author Yang Shihao
 * @date 2018/11/17
 */
class App : Application() {

    companion object {
        var instance: App by notNullSingleValue<App>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}