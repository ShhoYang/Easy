package com.hao.easy.mvvm.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.hao.easy.mvvm.http.WeChatApi
import com.hao.easy.mvvm.model.Article

class FirstViewModel : ViewModel() {

    val liveData: LiveData<PagedList<Article>> =
            LivePagedListBuilder(MainDataSourceFactory(WeChatApi()),
                    PagedList.Config.Builder()
                            .setEnablePlaceholders(false)
                            .setInitialLoadSizeHint(20)
                            .setPageSize(20)
                            .build())
                    .build()

}