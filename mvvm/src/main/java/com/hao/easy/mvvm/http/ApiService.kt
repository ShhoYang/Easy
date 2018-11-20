package com.hao.easy.mvvm.http

import com.hao.easy.mvvm.base.HttpResult
import com.hao.easy.mvvm.first.model.ArticleList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Yang Shihao
 * @date 2018/11/19
 */

interface ApiService {

    companion object {
         const val BASE_URL = "http://wanandroid.com/wxarticle/"
    }

    @GET("list/{authorId}/{page}/json")
    fun getArticleList(@Path("authorId") authorId: Int, @Path("page") page: Int): Observable<HttpResult<ArticleList>>
}