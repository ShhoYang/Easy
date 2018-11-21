package com.hao.easy.mvvm.base.http

import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.base.model.HttpResult
import com.hao.easy.mvvm.base.model.ListPaged
import com.hao.easy.mvvm.newatricles.model.NewArticle
import com.hao.easy.mvvm.wechat.model.Author
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Yang Shihao
 * @date 2018/11/19
 */

interface Api {

    @GET("wxarticle/chapters/json")
    fun getWeChatAuthors(): Observable<HttpResult<ArrayList<Author>>>

    @GET("wxarticle/list/{authorId}/{page}/json")
    fun getWeChatArticles(@Path("authorId") authorId: Int = 409, @Path("page") page: Int): Observable<HttpResult<ListPaged<Article>>>

    @GET("article/listproject/{page}/json")
    fun getNewArticles(@Path("page") page: Int): Observable<HttpResult<ListPaged<NewArticle>>>
}