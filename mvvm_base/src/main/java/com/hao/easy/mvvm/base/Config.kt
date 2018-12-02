package com.hao.easy.mvvm.base

import com.hao.easy.mvvm.base.user.User
import com.hao.easy.paging.db.UserDb
import kotlin.concurrent.thread

class Config private constructor() {

    companion object {
        private const val TAG = "Config"

        private const val KEY_USERNAME = "loginUserName"
        private const val KEY_TOKEN = "token_pass"

        private var instance: Config? = null

        fun instance(): Config {
            if (instance == null) {
                synchronized(Config::class.java) {
                    if (instance == null) {
                        instance = Config()
                    }
                }
            }
            return instance!!
        }
    }

    var user: User? = null
    var username: String? = null
        get() {
            return user?.username
        }
    var isLogin: Boolean = false
        get() {
            return field and (null != user)
        }

    fun init() {
        var username: String? = null
        var token: String? = null
        var cookies = App.instance.appComponent.cookies()
        cookies.forEach {
            if (it.name() == KEY_USERNAME) {
                var value = it.value()
                if ("\"\"" != value) {
                    username = value
                }

            } else if (it.name() == KEY_TOKEN) {
                var value = it.value()
                if ("\"\"" != value) {
                    token = value
                }
            }
        }

        if ((null != username) and (null != token)) {
            var user = UserDb.instance().userDao().queryUser(username!!)
            if (null != user) {
                this.user = user
                isLogin = true
            }
        }
    }

    fun logged(user: User) {
        this.user = user
        isLogin = true
        thread { UserDb.instance().userDao().insert(user) }
    }

    fun logout() {
        user?.apply {
            thread { UserDb.instance().userDao().delete(this) }
        }
        user = null
        isLogin = false
        App.instance.appComponent.apply {
            okHttpClient().dispatcher().cancelAll()
            persistentCookieJar().clear()
        }
    }
}

