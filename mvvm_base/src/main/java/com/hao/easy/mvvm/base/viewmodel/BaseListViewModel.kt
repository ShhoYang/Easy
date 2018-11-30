package com.hao.easy.mvvm.base.viewmodel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PageKeyedDataSource
import android.arch.paging.PagedList
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.support.annotation.NonNull
import com.hao.easy.mvvm.base.datasource.DataSourceFactory
import com.hao.easy.mvvm.base.datasource.PagedDataLoader
import com.socks.library.KLog

abstract class BaseListViewModel<T> : BaseViewModel(), PagedDataLoader<T> {

    open fun pageSize(): Int {
        return 20
    }

    companion object {
        private const val TAG = "BaseViewModel"
    }

    private val dataSourceFactory: DataSourceFactory<T> by lazy {
        DataSourceFactory(this)
    }

    private val loadLiveData = LivePagedListBuilder(dataSourceFactory, pageSize()).build()

    private val refreshLiveData: MutableLiveData<Boolean> = MutableLiveData()

    private val loadMoreLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    private val notifyItemLiveData: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }

    private val removeItemLiveData: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }

    fun invalidate() {
        dataSourceFactory.sourceLiveData.value?.invalidate()
    }

    fun observeDataObserver(@NonNull owner: LifecycleOwner,
                            data: (PagedList<T>) -> Unit,
                            refreshResult: (Boolean?) -> Unit,
                            loadMoreResult: (Boolean?) -> Unit) {
        loadLiveData.observe(owner, Observer {
            it?.apply(data)
        })

        refreshLiveData.observe(owner, Observer {
            refreshResult(it)
        })

        loadMoreLiveData.observe(owner, Observer {
            loadMoreResult(it)
        })
    }

    fun observeAdapterObserver(@NonNull owner: LifecycleOwner,
                               notifyItem: (Int) -> Unit,
                               removeItem: (Int) -> Unit) {
        notifyItemLiveData.observe(owner, Observer {
            notifyItem(it!!)
        })

        removeItemLiveData.observe(owner, Observer {
            removeItem(it!!)
        })
    }

    final override fun loadInitial(params: PageKeyedDataSource.LoadInitialParams<Int>, callback: PageKeyedDataSource.LoadInitialCallback<Int, T>) {
        refresh()
        KLog.d(TAG, "loadInitial")
        loadData(1) {
            when {
                it == null -> refreshLiveData.value = false
                it.size < PAGE_SIZE -> {
                    callback.onResult(it, null, null)
                    refreshLiveData.value = null
                }
                else -> {
                    callback.onResult(it, null, 2)
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
                it.size < pageSize() -> {
                    callback.onResult(it, null)
                    loadMoreLiveData.value = null
                }
                else -> {
                    callback.onResult(it, params.key + 1)
                    loadMoreLiveData.value = true
                }
            }
        }
    }

    fun notifyItem(position: Int) {
        notifyItemLiveData.value = position
        notifyItemLiveData.value = -1
    }

    override fun refresh() {
    }

    override fun loadMore() {
    }

    abstract fun loadData(page: Int, onResponse: (ArrayList<T>?) -> Unit)
}
