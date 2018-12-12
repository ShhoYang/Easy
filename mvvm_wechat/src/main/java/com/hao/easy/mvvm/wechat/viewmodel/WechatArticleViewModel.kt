package com.hao.easy.mvvm.wechat.viewmodel

import com.hao.easy.mvvm.base.Config
import com.hao.easy.mvvm.base.extensions.main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.repository.Api
import kotlin.properties.Delegates

class WechatArticleViewModel : BaseArticleViewModel() {

    var isLogin by Delegates.observable(Config.isLogin) { _, old, new ->
        if (old != new) {
            invalidate()
        }
    }

    var authorId: Int = 409

    override fun onResume() {
        super.onResume()
        isLogin = Config.isLogin
    }

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {
        Api.getWechatArticles(authorId, page).main().subscribeBy({
            onResponse(it?.datas)
        }, {
            onResponse(null)
        }).add()
    }
}