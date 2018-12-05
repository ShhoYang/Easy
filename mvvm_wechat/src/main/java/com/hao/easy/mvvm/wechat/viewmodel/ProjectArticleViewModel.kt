package com.hao.easy.mvvm.wechat.viewmodel

import com.hao.easy.mvvm.base.extensions.main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.repository.Api

class ProjectArticleViewModel : BaseArticleViewModel() {

    override fun pageSize() = 6

    var typeId: Int = 0

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {

        Api.getProjectArticles(page - 1, typeId).main().subscribeBy({
            onResponse(it?.datas)
        }, {
            onResponse(null)
        }).add()
    }
}