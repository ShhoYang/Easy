package com.hao.easy.mvvm.user.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseViewModel
import com.hao.easy.mvvm.user.http.Api

/**
 * @author Yang Shihao
 * @date 2018/11/25
 */
class LoginViewModel : BaseViewModel() {

    companion object {
        private const val TAG = "LoginViewModel"
    }

    var loggedLiveData = MutableLiveData<String>()

    fun login(username: String, password: String) {
        Api.login(username, password).subscribeBy({
            loggedLiveData.value = null
        }, {
            loggedLiveData.value = it
        }).add()
    }
}