package com.hao.easy.mvvm.base.http

import com.hao.easy.mvvm.User
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.base.model.HttpResult
import com.hao.easy.mvvm.base.model.ListPaged
import com.hao.easy.mvvm.newatricles.model.NewArticle
import com.hao.easy.mvvm.wechat.model.Ad
import com.hao.easy.mvvm.wechat.model.Author
import io.reactivex.Observable
import retrofit2.http.*

/**
 * @author Yang Shihao
 * @date 2018/11/19
 */

interface Api {

    @FormUrlEncoded
    @POST("user/login")
    fun login(@Field("username") username: String, @Field("password") password: String): Observable<HttpResult<User>>

    @GET("banner/json")
    fun getAd(): Observable<HttpResult<ArrayList<Ad>>>

    @GET("wxarticle/chapters/json")
    fun getWeChatAuthors(): Observable<HttpResult<ArrayList<Author>>>

    @GET("wxarticle/list/{authorId}/{page}/json")
    fun getWeChatArticles(@Path("authorId") authorId: Int = 409, @Path("page") page: Int): Observable<HttpResult<ListPaged<Article>>>

    @GET("article/listproject/{page}/json")
    fun getNewArticles(@Path("page") page: Int): Observable<HttpResult<ListPaged<NewArticle>>>
}