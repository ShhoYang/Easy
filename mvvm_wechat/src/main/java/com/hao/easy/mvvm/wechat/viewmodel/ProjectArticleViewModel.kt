package com.hao.easy.mvvm.wechat.viewmodel

import com.hao.easy.mvvm.base.Config
import com.hao.easy.mvvm.base.extensions.io_main
import com.hao.easy.mvvm.base.extensions.main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.wechat.Router
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.repository.Api

class ProjectArticleViewModel : BaseListViewModel<Article>() {

    override fun pageSize() = 6

    var typeId: Int = 0

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {

        Api.getProjectArticles(page - 1, typeId).main().subscribeBy({
            onResponse(it?.datas)
        }, {
            onResponse(null)
        }).add()
    }

    fun collect(item: Article, position: Int) {
        if (!Config.instance().isLogin) {
            Router.startLogin()
            return
        }
        if (item.collect) {
            Api.cancelCollect(item.id).io_main().subscribeBy({
                item.collect = false
                notifyItem(position)
            }, {

            }).add()
        } else {
            Api.collect(item.id).io_main().subscribeBy({
                item.collect = true
                notifyItem(position)
            }, {

            }).add()
        }
    }
}