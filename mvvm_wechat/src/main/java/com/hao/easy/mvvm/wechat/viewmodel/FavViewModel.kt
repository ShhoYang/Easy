package com.hao.easy.mvvm.wechat.viewmodel

import com.hao.easy.mvvm.base.extensions.io_main
import com.hao.easy.mvvm.base.extensions.main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.repository.Api

/**
 * @author Yang Shihao
 * @date 2018/12/3
 */
class FavViewModel : BaseListViewModel<Article>() {

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {
        Api.getMyFav(page - 1).main().subscribeBy({
            onResponse(it?.datas)
        }, {
            onResponse(null)
        }).add()
    }

    fun cancelCollect(item: Article, position: Int) {
        Api.cancelCollect(item.originId).io_main().subscribeBy({
           //invalidate()
           removeItem(position)
        }, {

        }).add()
    }
}