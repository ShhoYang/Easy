package com.hao.easy.mvvm.android.repository

import com.hao.easy.mvvm.android.model.Article
import com.hao.easy.mvvm.base.model.HttpResult
import com.hao.easy.mvvm.base.model.ListPaged
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Yang Shihao
 * @date 2018/11/19
 */

interface Api {

    @GET("article/listproject/{page}/json")
    fun getAtricles(@Path("page") page: Int): Observable<HttpResult<ListPaged<Article>>>
}