package com.hao.easy.mvvm.wechat.viewmodel

import com.hao.easy.mvvm.base.extensions.io_main
import com.hao.easy.mvvm.base.extensions.subscribeBy
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.wechat.model.Knowledge
import com.hao.easy.mvvm.wechat.repository.Api

class KnowledgeViewModel : BaseListViewModel<Knowledge>() {

    override fun pageSize() = Int.MAX_VALUE

    override fun loadData(page: Int, onResponse: (ArrayList<Knowledge>?) -> Unit) {
        Api.getKnowledge().io_main().subscribeBy({
            onResponse(it)
        }, {
            onResponse(null)
        }).add()
    }
}

