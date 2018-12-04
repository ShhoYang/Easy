package com.hao.easy.mvvm.wechat

import com.alibaba.android.arouter.launcher.ARouter

object Router {

    fun startLogin() {
        ARouter.getInstance().build("/user/LoginActivity").navigation()
    }
}