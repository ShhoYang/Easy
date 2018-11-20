package com.hao.easy.mvvm.common

import android.app.Application
import com.hao.easy.mvvm.extensions.notNullSingleValue
import com.socks.library.KLog

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class App : Application() {

    companion object {

        var instance by notNullSingleValue<App>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        KLog.init(true)
    }
}