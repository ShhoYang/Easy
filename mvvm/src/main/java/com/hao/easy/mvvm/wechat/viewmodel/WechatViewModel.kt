package com.hao.easy.mvvm.wechat.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.hao.easy.mvvm.base.viewmodel.BaseViewModel
import com.hao.easy.mvvm.common.FragmentCreator
import com.hao.easy.mvvm.extensions.subscribeBy
import com.hao.easy.mvvm.extensions.map_io_main
import com.hao.easy.mvvm.wechat.ui.fragment.WechatArticlesFragment

class WechatViewModel : BaseViewModel() {

    var adLiveData = MutableLiveData<List<String>>()

    val authorsLiveData: MutableLiveData<List<Pair<String, FragmentCreator>>> = MutableLiveData()

    fun initData() {
        api.getAd().map_io_main().subscribeBy {
            adLiveData.value = it.map { ad -> ad.imagePath }
        }
        api.getWeChatAuthors().map_io_main().subscribeBy {
            var fragments = it.map { author ->
                Pair<String, FragmentCreator>(author.name, object : FragmentCreator {
                    override fun create() = WechatArticlesFragment.instance(author.id)
                })
            }
            authorsLiveData.value = fragments
        }
    }
}