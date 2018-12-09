package com.hao.easy.mvvm.wechat

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.hao.easy.mvvm.base.extensions.notNullSingleValue
import com.hao.easy.mvvm.base.provider.ILikeApplication
import com.hao.easy.mvvm.wechat.di.component.WechatAppComponent
import dagger.android.AndroidInjector

/**
 * @author Yang Shihao
 * @date 2018/12/7
 */

@Route(path = "/wechat/WechatApp")
class WechatApp : ILikeApplication() {

    lateinit var appComponent: WechatAppComponent

    companion object {
        var instance by notNullSingleValue<WechatApp>()
    }

    override fun applicationInjector(): AndroidInjector<WechatApp> {
        return appComponent
    }

    override fun init(context: Context?) {

    }

    override fun onCreate() {
//        instance = this
//        appComponent = DaggerWechatAppComponent.builder().appComponent(App.instance.appComponent).build()
//        appComponent.inject(this)
        super.onCreate()
    }
}
