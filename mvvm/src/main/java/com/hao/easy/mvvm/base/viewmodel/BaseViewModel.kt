package com.hao.easy.mvvm.base.viewmodel

import android.arch.lifecycle.ViewModel
import com.hao.easy.mvvm.http.Api

abstract class BaseViewModel : ViewModel() {

    companion object {
        const val TAG = "BaseViewModel"
    }

    var api: Api? = null
}
