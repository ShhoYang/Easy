package com.hao.easy.mvvm.viewmodel

import android.arch.paging.DataSource
import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.hao.easy.mvvm.extensions.doSubscribe
import com.hao.easy.mvvm.http.WeChatApi
import com.hao.easy.mvvm.model.Article

class MainDataSource(private val api: WeChatApi) : PageKeyedDataSource<Int, Article>() {


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Article>) {
        api.getArticleList().doSubscribe {
            Log.d("MainDataSource", "loadInitial ${params.requestedLoadSize}----${it.curPage}/${it.pageCount}")
            callback.onResult(it.datas, 0, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {
        api.getArticleList(params.key).doSubscribe {
            Log.d("MainDataSource", "loadAfter ${params.key}----${it.curPage}/${it.pageCount}")
            callback.onResult(it.datas, params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {
    }
}


class MainDataSourceFactory(private val api: WeChatApi) : DataSource.Factory<Int, Article>() {

    override fun create(): DataSource<Int, Article> = MainDataSource(api)
}