package com.hao.easy.mvvm.wechat.repository

import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.model.HttpResult
import com.hao.easy.mvvm.base.model.ListPaged
import com.hao.easy.mvvm.wechat.model.Ad
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.model.Author
import com.hao.easy.mvvm.wechat.model.ProjectType
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Yang Shihao
 * @date 2018/11/19
 */

object Api : Service by App.instance.appComponent.retrofit().create(Service::class.java)

interface Service {

    @GET("banner/json")
    fun getAd(): Observable<HttpResult<ArrayList<Ad>>>

    @GET("wxarticle/chapters/json")
    fun getAuthors(): Observable<HttpResult<ArrayList<Author>>>

    @GET("wxarticle/list/{authorId}/{page}/json")
    fun getWechatArticles(@Path("authorId") authorId: Int = 409, @Path("page") page: Int): Observable<HttpResult<ListPaged<Article>>>

    @GET("project/tree/json")
    fun getProjectType(): Observable<HttpResult<ArrayList<ProjectType>>>

    @GET("article/listproject/{page}/json")
    fun getNewProjectArticles(@Path("page") page: Int): Observable<HttpResult<ListPaged<Article>>>

    @GET("project/list/{page}/json")
    fun getProjectArticles(@Path("page") page: Int, @Query("cid") cid: Int): Observable<HttpResult<ListPaged<Article>>>

    @GET("lg/collect/list/{page}/json")
    fun getMyFav(@Path("page") page:Int): Observable<HttpResult<ListPaged<Article>>>

    @POST("lg/collect/{id}/json")
    fun collect(@Path("id") id: Int): Observable<HttpResult<Void>>

    @POST("lg/uncollect_originId/{id}/json")
    fun cancelCollect(@Path("id") id: Int): Observable<HttpResult<Void>>
}