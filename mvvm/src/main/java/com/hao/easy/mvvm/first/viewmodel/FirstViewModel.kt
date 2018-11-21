package com.hao.easy.mvvm.first.viewmodel

import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.common.App
import com.hao.easy.mvvm.extensions.doSubscribe
import com.hao.easy.mvvm.extensions.map
import com.hao.easy.mvvm.first.model.Article
import org.jetbrains.anko.toast

class FirstViewModel : BaseListViewModel<Article>() {

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {
        api?.getArticleList(409, page)?.map()?.doSubscribe({
            if (page % 5 == 0) {
                onResponse(it.datas.take(10) as ArrayList<Article>)
            } else {
                onResponse(it.datas)
            }
        }, {
            onResponse(null)
            App.instance.toast("加载失败")
        })
    }
}