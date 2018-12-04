package com.hao.easy.mvvm.user.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.hao.easy.mvvm.base.Config
import com.hao.easy.mvvm.base.extensions.io_main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseViewModel
import com.hao.easy.mvvm.user.repository.Api

/**
 * @author Yang Shihao
 * @date 2018/11/25
 */
class LoginViewModel : BaseViewModel() {

    var loginLiveData = MutableLiveData<String>()

    fun login(username: String, password: String) {
        Api.login(username, password).io_main().subscribeBy({
            Config.instance().logged(it!!)
            loginLiveData.value = null
        }, {
            loginLiveData.value = it
        }).add()
    }
}