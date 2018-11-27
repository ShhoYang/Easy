package com.hao.easy.mvvm.android.http

import com.hao.easy.mvvm.android.model.Article
import com.hao.easy.mvvm.base.model.*
import io.reactivex.Observable
import retrofit2.http.*

/**
 * @author Yang Shihao
 * @date 2018/11/19
 */

interface Api {

    @GET("article/listproject/{page}/json")
    fun getAtricles(@Path("page") page: Int): Observable<HttpResult<ListPaged<Article>>>
}