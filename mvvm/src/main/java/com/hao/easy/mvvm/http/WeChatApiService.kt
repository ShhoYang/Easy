package com.hao.easy.mvvm.http

import com.hao.easy.mvvm.model.ArticleList
import com.hao.easy.mvvm.model.HttpResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Yang Shihao
 * @date 2018/11/19
 */

interface WeChatApiService {

    companion object {
         const val BASE_URL = "http://wanandroid.com/wxarticle/"
    }

    @GET("list/{authorId}/{page}/json")
    fun getArticleList(@Path("authorId") authorId: Int, @Path("page") page: Int): Observable<HttpResult<ArticleList>>
}