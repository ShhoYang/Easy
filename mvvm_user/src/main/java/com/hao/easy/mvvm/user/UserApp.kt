package com.hao.easy.mvvm.user

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.extensions.notNullSingleValue
import com.hao.easy.mvvm.base.provider.ILikeApplication
import com.hao.easy.mvvm.user.di.component.DaggerUserAppComponent
import com.hao.easy.mvvm.user.di.component.UserAppComponent
import dagger.android.AndroidInjector

/**
 * @author Yang Shihao
 * @date 2018/12/7
 */

@Route(path = "/user/UserApp")
class UserApp : ILikeApplication() {

    lateinit var appComponent: UserAppComponent

    companion object {
        var instance by notNullSingleValue<UserApp>()
    }

    override fun applicationInjector(): AndroidInjector<UserApp> {
        return appComponent
    }

    override fun init(context: Context?) {

    }

    override fun onCreate() {
        instance = this
        appComponent = DaggerUserAppComponent.builder().appComponent(App.instance.appComponent).build()
        appComponent.inject(this)
        super.onCreate()
    }
}
