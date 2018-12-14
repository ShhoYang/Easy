package com.hao.easy.mvvm.wechat.viewmodel

import com.hao.easy.mvvm.base.extensions.main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.repository.Api

class KotlinViewModel : BaseArticleViewModel() {

    var key = "kotlin"

    override fun pageSize() = 10

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {
        Api.search(page - 1, key).main().subscribeBy({
            onResponse(it?.datas)
        }, {
            onResponse(null)
        }).add()
    }
}