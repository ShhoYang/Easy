package com.hao.easy.mvvm.base.viewmodel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PageKeyedDataSource
import android.arch.paging.PagedList
import android.support.annotation.NonNull
import com.hao.easy.mvvm.base.datasource.DataSourceFactory
import com.hao.easy.mvvm.base.datasource.PagedDataLoader
import com.socks.library.KLog

abstract class BaseListViewModel<T> : BaseViewModel(), PagedDataLoader<T> {

    companion object {
        const val PAGE_SIZE = 20
        const val TAG = "BaseViewModel"
    }

    private val dataSourceFactory: DataSourceFactory<T> by lazy {
        DataSourceFactory(this)
    }

    private val loadLiveData = LivePagedListBuilder(dataSourceFactory, PAGE_SIZE).build()

    private val refreshLiveData: MutableLiveData<Boolean> = MutableLiveData()

    private val loadMoreLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun invalidate() {
        dataSourceFactory.sourceLiveData.value?.invalidate()
    }

    fun observe(@NonNull owner: LifecycleOwner, data: (PagedList<T>) -> Unit, refreshResult: (Boolean) -> Unit, loadMoreResult: (Boolean) -> Unit) {
        loadLiveData.observe(owner, Observer {
            it?.apply(data)
        })

        refreshLiveData.observe(owner, Observer {
            refreshResult(it ?: false)
        })

        loadMoreLiveData.observe(owner, Observer {
            loadMoreResult(it ?: false)
        })
    }

    final override fun loadInitial(params: PageKeyedDataSource.LoadInitialParams<Int>, callback: PageKeyedDataSource.LoadInitialCallback<Int, T>) {
        refresh()
        KLog.d(TAG, "loadInitial")
        loadData(1) {
            when {
                it == null -> refreshLiveData.value = false
                it.size < PAGE_SIZE -> {
                    callback.onResult(it, 0, 1)
                    refreshLiveData.value = true
                }
                else -> {
                    callback.onResult(it, 0, 2)
                    refreshLiveData.value = true
                }
            }
        }
    }

    final override fun loadAfter(params: PageKeyedDataSource.LoadParams<Int>, callback: PageKeyedDataSource.LoadCallback<Int, T>) {
        loadMore()
        KLog.d(TAG, "loadAfter--${params.key}")
        loadData(params.key) {
            when {
                it == null -> loadMoreLiveData.value = false
                it.size < PAGE_SIZE -> {
                    callback.onResult(it, params.key)
                    loadMoreLiveData.value = true
                }
                else -> {
                    callback.onResult(it, params.key + 1)
                    loadMoreLiveData.value = true
                }
            }
        }
    }

    override fun refresh() {
    }

    override fun loadMore() {
    }

    abstract fun loadData(page: Int, onResponse: (ArrayList<T>?) -> Unit)
}
