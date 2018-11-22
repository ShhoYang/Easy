package com.hao.easy.mvvm.wechat.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.hao.easy.mvvm.base.viewmodel.BaseViewModel
import com.hao.easy.mvvm.extensions.doSubscribe
import com.hao.easy.mvvm.extensions.map_io_main
import com.hao.easy.mvvm.wechat.model.Author

class WechatViewModel : BaseViewModel() {

    val authorsLiveData: MutableLiveData<ArrayList<Author>> = MutableLiveData()

    fun initData() {
        api.getWeChatAuthors().map_io_main().doSubscribe {
            authorsLiveData.value = it
        }
    }
}