package com.hao.easy.mvvm.wechat.viewmodel

import com.hao.easy.mvvm.base.Config
import com.hao.easy.mvvm.base.Config.isLogin
import com.hao.easy.mvvm.base.extensions.io_main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.wechat.Router
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.repository.Api
import com.socks.library.KLog

abstract class BaseArticleViewModel : BaseListViewModel<Article>() {

    fun collect(item: Article, position: Int) {
        KLog.d("aaaaaaaaaaaaaa", "user ${Config.toString()}")
        if (!Config.isLogin) {
            Router.startLogin()
            return
        }
        Api.collect(item.id).io_main().subscribeBy({
            item.collect = true
            notifyItem(position, "fav")
        }, {

        }).add()
    }

    open fun cancelCollect(item: Article, position: Int) {
        KLog.d("aaaaaaaaaaaaaa", "user ${Config.toString()}")
        if (!Config.isLogin) {
            Router.startLogin()
            return
        }
        Api.cancelCollect(item.id).io_main().subscribeBy({
            item.collect = false
            notifyItem(position, "fav")
        }, {

        }).add()
    }
}