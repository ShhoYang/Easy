package com.hao.easy.mvvm.wechat.viewmodel

import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.extensions.doSubscribe
import com.hao.easy.mvvm.extensions.map_main
import com.hao.easy.mvvm.wechat.model.Article

class WechatArticlesViewModel : BaseListViewModel<Article>() {

    var authorId:Int = 409

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {
        api.getWeChatArticles(authorId, page).map_main().doSubscribe({
            onResponse(it.datas)
        }, {
            onResponse(null)
        })
    }
}