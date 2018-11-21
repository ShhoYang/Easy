package com.hao.easy.mvvm.base.viewmodel

import android.arch.lifecycle.ViewModel
import com.hao.easy.mvvm.base.http.Api

abstract class BaseViewModel : ViewModel() {

    companion object {
        const val TAG = "BaseViewModel"
    }

    lateinit var api: Api
}
