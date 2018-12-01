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
class UserViewModel : BaseViewModel() {

    companion object {
        private const val TAG = "UserViewModel"
    }

    var logoutLiveData = MutableLiveData<String>()

    fun logout() {
        Api.logout().io_main().subscribeBy({
            logoutLiveData.value = null
        }, {
            logoutLiveData.value = null
        }).add()
    }
}