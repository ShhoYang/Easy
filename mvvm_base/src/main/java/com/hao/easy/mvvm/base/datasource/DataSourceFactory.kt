package com.hao.easy.mvvm.base.datasource

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource

class DataSourceFactory<T>(var dataLoader: PagedDataLoader<T>) : DataSource.Factory<Int, T>() {

    val sourceLiveData = MutableLiveData<PagedDataSource<T>>()

    override fun create(): PagedDataSource<T>? {
        val dataSource = PagedDataSource(dataLoader)
        sourceLiveData.postValue(dataSource)
        sourceLiveData.value?.invalidate()
        return dataSource
    }
}
