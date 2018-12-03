package com.hao.easy.mvvm.android.viewmodel

import com.alibaba.android.arouter.launcher.ARouter
import com.hao.easy.mvvm.android.model.Article
import com.hao.easy.mvvm.android.repository.Api
import com.hao.easy.mvvm.base.Config
import com.hao.easy.mvvm.base.extensions.io_main
import com.hao.easy.mvvm.base.extensions.main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel

class ArticleViewModel : BaseListViewModel<Article>() {

    override fun pageSize() = 6

    var typeId: Int = 0

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {

        Api.getArticles(page - 1,typeId).main().subscribeBy({
            onResponse(it?.datas)
        }, {
            onResponse(null)
        }).add()
    }

    fun collect(item: Article, position: Int) {
        if (!Config.instance().isLogin) {
            ARouter.getInstance().build("/user/LoginActivity").navigation()
            return
        }
        if (item.collect) {
            Api.cancelCollect(item.id).io_main().subscribeBy({
                item.collect = false
                notifyItem(position)
            }, {

            })
        } else {
            Api.collect(item.id).io_main().subscribeBy({
                item.collect = true
                notifyItem(position)
            }, {

            })
        }
    }
}