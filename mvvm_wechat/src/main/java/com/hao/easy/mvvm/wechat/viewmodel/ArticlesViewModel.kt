package com.hao.easy.mvvm.wechat.viewmodel

import com.hao.easy.mvvm.base.extensions.io_main
import com.hao.easy.mvvm.base.extensions.main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.repository.Api

class ArticlesViewModel : BaseListViewModel<Article>() {

    companion object {
        private const val TAG = "ArticlesViewModel"
    }

    var authorId: Int = 409

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {
        Api.getArticles(authorId, page).main().subscribeBy({
            onResponse(it?.datas)
        }, {
            onResponse(null)
        }).add()
    }

    fun collect(item: Article, position: Int) {
        if(item.collect){
            Api.cancelCollect(item.id).io_main().subscribeBy({
                item.collect = false
                notifyItem(position)
            }, {

            })
        }else {
            Api.collect(item.id).io_main().subscribeBy({
                item.collect = true
                notifyItem(position)
            }, {

            })
        }
    }
}