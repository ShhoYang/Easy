package com.hao.easy.mvvm.base

import android.text.TextUtils
import android.util.Log

object Config {

    var username: String = ""
        get() {
            Log.e("111111111111111",field)
            if (!TextUtils.isEmpty(field)) {
                return field
            }
            var cookies = App.instance.appComponent.cookies()
            cookies.forEach {
                Log.e("111111111111111","name = ${it.name()} -- ${it.value()}")
                if (it.name() == "loginUserName") {
                    field = it.value()
                    return field
                }
            }
            return ""
        }

    fun isLogin(): Boolean {
        var name: String? = null
        var token: String? = null
        var cookies = App.instance.appComponent.cookies()
        cookies.forEach {
            if (it.name() == "loginUserName") {
                name = it.value()
            } else if (it.name() == "token_pass") {
                token = it.value()
            }
        }
        return !TextUtils.isEmpty(name) && !TextUtils.isEmpty(token)
    }

    fun logout() {
        username = ""
        App.instance.appComponent.apply {
            okHttpClient().dispatcher().cancelAll()
            persistentCookieJar().clear()
        }
    }
}

