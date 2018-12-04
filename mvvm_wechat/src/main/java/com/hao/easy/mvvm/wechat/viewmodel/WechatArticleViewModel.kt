package com.hao.easy.mvvm.wechat.viewmodel

import com.hao.easy.mvvm.base.Config
import com.hao.easy.mvvm.base.extensions.io_main
import com.hao.easy.mvvm.base.extensions.main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.wechat.Router
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.repository.Api
import kotlin.properties.Delegates

class WechatArticleViewModel : BaseListViewModel<Article>() {

    var isLogin by Delegates.observable(Config.instance().isLogin) { _, old, new ->
        if (old != new) {
            invalidate()
        }
    }

    var authorId: Int = 409

    override fun onResume() {
        super.onResume()
        isLogin = Config.instance().isLogin
    }

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {
        Api.getWechatArticles(authorId, page).main().subscribeBy({
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