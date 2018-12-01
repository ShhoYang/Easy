package com.hao.easy.mvvm.android.viewmodel

import com.hao.easy.mvvm.android.repository.Api
import com.hao.easy.mvvm.android.model.Article
import com.hao.easy.mvvm.base.extensions.main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel

class ArticleViewModel : BaseListViewModel<Article>() {

    lateinit var api: Api

    override fun pageSize() = 6

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {
        api.getAtricles(page - 1).main().subscribeBy({
            onResponse(it?.datas)
        }, {
            onResponse(null)
        }).add()
    }
}