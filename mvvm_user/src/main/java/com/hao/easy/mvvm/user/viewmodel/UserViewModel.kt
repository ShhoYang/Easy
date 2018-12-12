package com.hao.easy.mvvm.user.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.hao.easy.mvvm.base.Config
import com.hao.easy.mvvm.base.extensions.io_main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.user.User
import com.hao.easy.mvvm.base.viewmodel.BaseViewModel
import com.hao.easy.mvvm.user.repository.Api

/**
 * @author Yang Shihao
 * @date 2018/11/25
 */
class UserViewModel : BaseViewModel() {

    var loginLiveData = MutableLiveData<User>()

    var logoutLiveData = MutableLiveData<String>()

    override fun onResume() {
        loginLiveData.value = Config.user
    }

    fun logout() {
        Api.logout().io_main().subscribeBy({
            logoutLiveData.value = null
        }, {
            logoutLiveData.value = null
        }).add()
    }
}