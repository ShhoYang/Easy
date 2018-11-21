package com.hao.easy.mvvm.newatricles.viewmodel

import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.extensions.doSubscribe
import com.hao.easy.mvvm.extensions.map_main
import com.hao.easy.mvvm.newatricles.model.NewArticle

class NewArticlesViewModel : BaseListViewModel<NewArticle>() {

    override fun pageSize() = 6

    override fun loadData(page: Int, onResponse: (ArrayList<NewArticle>?) -> Unit) {
        api.getNewArticles(page - 1).map_main().doSubscribe({
            onResponse(it.datas)
        }, {
            onResponse(null)
        })
    }
}