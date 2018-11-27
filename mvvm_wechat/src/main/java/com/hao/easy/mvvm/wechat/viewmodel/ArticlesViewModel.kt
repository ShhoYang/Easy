package com.hao.easy.mvvm.wechat.viewmodel

import com.hao.easy.mvvm.base.extensions.map_main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.wechat.http.Api
import com.hao.easy.mvvm.wechat.model.Article

class ArticlesViewModel : BaseListViewModel<Article>() {
    lateinit var api: Api

    var authorId:Int = 409

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {
        api.getArticles(authorId, page).map_main().subscribeBy({
            onResponse(it.datas)
        }, {
            onResponse(null)
        }).add()
    }
}