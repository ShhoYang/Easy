package com.hao.easy.mvvm.wechat.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.hao.easy.mvvm.base.extensions.io_main
import com.hao.easy.mvvm.base.extensions.main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.model.ProjectType
import com.hao.easy.mvvm.wechat.repository.Api

class ProjectViewModel : BaseArticleViewModel() {

    override fun pageSize() = 6

    val typeLiveData = MutableLiveData<ArrayList<ProjectType>>()

    override fun loadData(page: Int, onResponse: (ArrayList<Article>?) -> Unit) {
        Api.getNewProjectArticles(page - 1).main().subscribeBy({
            onResponse(it?.datas)
        }, {
            onResponse(null)
        }).add()
    }

    override fun refresh() {
        Api.getProjectType().io_main().subscribeBy({
            if (it != null && !it.isEmpty()) {
                typeLiveData.value = it
            }
        }, {

        }).add()
    }
}