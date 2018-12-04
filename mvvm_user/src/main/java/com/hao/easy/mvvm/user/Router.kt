package com.hao.easy.mvvm.user

import com.alibaba.android.arouter.launcher.ARouter

object Router {
    fun startMainActivity() {
        ARouter.getInstance().build("/app/MainActivity").navigation()
    }

    fun startFavActivity() {
        ARouter.getInstance().build("/wechat/FavActivity").navigation()
    }
}