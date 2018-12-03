package com.hao.easy.mvvm.user.viewmodel

import com.hao.easy.mvvm.base.extensions.io_main
import com.hao.easy.mvvm.base.extensions.main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.user.model.Fav
import com.hao.easy.mvvm.user.repository.Api

/**
 * @author Yang Shihao
 * @date 2018/12/3
 */
class MyFavViewModel : BaseListViewModel<Fav>() {

    override fun loadData(page: Int, onResponse: (ArrayList<Fav>?) -> Unit) {
        Api.getMyFav(page - 1).main().subscribeBy({
            onResponse(it?.datas)
        }, {
            onResponse(null)
        }).add()
    }

    fun cancelCollect(item: Fav, position: Int) {
        Api.cancelCollect(item.originId).io_main().subscribeBy({
           invalidate()
           //removeItem(position)
        }, {

        })
    }
}