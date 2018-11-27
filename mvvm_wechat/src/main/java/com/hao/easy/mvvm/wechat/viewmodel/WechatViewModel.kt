package com.hao.easy.mvvm.wechat.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.hao.easy.mvvm.base.common.FragmentCreator
import com.hao.easy.mvvm.base.extensions.map_io_main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseViewModel
import com.hao.easy.mvvm.wechat.http.Api
import com.hao.easy.mvvm.wechat.ui.fragment.ArticlesFragment

class WechatViewModel : BaseViewModel() {

    lateinit var api: Api

    var adLiveData = MutableLiveData<List<String>>()

    val authorsLiveData: MutableLiveData<List<Pair<String, FragmentCreator>>> = MutableLiveData()

    fun initData() {
        api.getAd().map_io_main().subscribeBy {
            adLiveData.value = it.map { ad -> ad.imagePath }
        }.add()

        api.getAuthors().map_io_main().subscribeBy {
            var fragments = it.map { author ->
                Pair<String, FragmentCreator>(author.name, object : FragmentCreator {
                    override fun create() = ArticlesFragment.instance(author.id)
                })
            }
            authorsLiveData.value = fragments
        }.add()
    }
}