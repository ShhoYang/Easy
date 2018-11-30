package com.hao.easy.mvvm.wechat.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.hao.easy.mvvm.base.common.FragmentCreator
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseViewModel
import com.hao.easy.mvvm.wechat.http.Api
import com.hao.easy.mvvm.wechat.ui.fragment.ArticlesFragment

class WechatViewModel : BaseViewModel() {

    var adLiveData = MutableLiveData<List<String>>()

    val authorsLiveData: MutableLiveData<List<Pair<String, FragmentCreator>>> = MutableLiveData()

    fun initData() {
        Api.getAd().subscribeBy {
            adLiveData.value = it?.map { ad -> ad.imagePath }
        }.add()

        Api.getAuthors().subscribeBy {
            var fragments = it?.map { author ->
                Pair<String, FragmentCreator>(author.name, object : FragmentCreator {
                    override fun create() = ArticlesFragment.instance(author.id)
                })
            }
            authorsLiveData.value = fragments
        }.add()
    }
}