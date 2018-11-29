package com.hao.easy.mvvm.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.hao.easy.mvvm.base.extensions.notNullSingleValue
import com.hao.easy.mvvm.inject.component.AppComponent
import com.hao.easy.mvvm.inject.component.DaggerAppComponent
import com.hao.easy.mvvm.inject.module.AppModule
import com.socks.library.KLog
import com.tencent.smtt.sdk.QbSdk

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
open class App : Application() {


    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        var instance by notNullSingleValue<App>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        KLog.init(true)
        QbSdk.initX5Environment(this, null)
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }
}