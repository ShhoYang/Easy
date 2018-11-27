package com.hao.easy.mvvm.wechat.http

import com.hao.easy.mvvm.base.model.*
import com.hao.easy.mvvm.wechat.model.Ad
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.model.Author
import io.reactivex.Observable
import retrofit2.http.*

/**
 * @author Yang Shihao
 * @date 2018/11/19
 */

interface Api {
    @GET("banner/json")
    fun getAd(): Observable<HttpResult<ArrayList<Ad>>>

    @GET("wxarticle/chapters/json")
    fun getAuthors(): Observable<HttpResult<ArrayList<Author>>>

    @GET("wxarticle/list/{authorId}/{page}/json")
    fun getArticles(@Path("authorId") authorId: Int = 409, @Path("page") page: Int): Observable<HttpResult<ListPaged<Article>>>
}