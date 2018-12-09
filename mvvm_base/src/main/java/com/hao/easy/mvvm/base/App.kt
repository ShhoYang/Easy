package com.hao.easy.mvvm.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.hao.easy.mvvm.base.di.component.AppComponent
import com.hao.easy.mvvm.base.di.component.DaggerAppComponent
import com.hao.easy.mvvm.base.extensions.notNullSingleValue
import com.hao.easy.mvvm.base.provider.ILikeApplication
import com.socks.library.KLog
import com.tencent.smtt.sdk.QbSdk

/**
 * @author Yang Shihao
@date 2018/11/18
 */

open class App : Application() {

    lateinit var userApp: ILikeApplication

    lateinit var appComponent: AppComponent

    companion object {
        var instance by notNullSingleValue<App>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        KLog.init(true)
        QbSdk.initX5Environment(this, null)
        appComponent = DaggerAppComponent.create()
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
        userApp = ARouter.getInstance()
                .build("/user/UserApp")
                .navigation() as ILikeApplication
        userApp.onCreate()

//       var  userApp2 = ARouter.getInstance()
//                .build("/wechat/WechatApp")
//                .navigation() as ILikeApplication
//        userApp2.onCreate()
    }
}