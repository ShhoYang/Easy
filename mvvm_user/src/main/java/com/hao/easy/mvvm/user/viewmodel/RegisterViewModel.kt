package com.hao.easy.mvvm.user.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.hao.easy.mvvm.base.extensions.io_main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseViewModel
import com.hao.easy.mvvm.user.repository.Api

/**
 * @author Yang Shihao
 * @date 2018/11/25
 */
class RegisterViewModel : BaseViewModel() {

    companion object {
        private const val TAG = "RegisterViewModel"
    }

    var registerLiveData = MutableLiveData<String>()

    fun register(username: String, password: String) {
        Api.register(username, password, password).io_main().subscribeBy({
            registerLiveData.value = null
        }, {
            registerLiveData.value = it
        }).add()
    }
}