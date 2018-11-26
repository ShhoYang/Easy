package com.hao.easy.mvvm.base.datasource

import android.arch.paging.PageKeyedDataSource

interface PagedDataLoader<T> {

    fun loadInitial(params: PageKeyedDataSource.LoadInitialParams<Int>, callback: PageKeyedDataSource.LoadInitialCallback<Int, T>)

    fun loadAfter(params: PageKeyedDataSource.LoadParams<Int>, callback: PageKeyedDataSource.LoadCallback<Int, T>)

    fun refresh()

    fun loadMore()
}