package com.hao.easy.mvvm.wechat.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.hao.easy.mvvm.base.Config
import com.hao.easy.mvvm.base.extensions.io_main
import com.hao.easy.mvvm.base.extensions.main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.wechat.Router
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.model.ProjectType
import com.hao.easy.mvvm.wechat.repository.Api

class ProjectViewModel : BaseListViewModel<Article>() {

    override fun pageSize() = 6

    val typeLiveData = MutableLiveData<ArrayList<ProjectType>>()

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {

        if (page == 1) {
            Api.getProjectType().io_main().subscribeBy({
                if (it != null && !it.isEmpty()) {
                    typeLiveData.value = it
                }
            }, {

            }).add()
        }

        Api.getNewProjectArticles(page - 1).main().subscribeBy({
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