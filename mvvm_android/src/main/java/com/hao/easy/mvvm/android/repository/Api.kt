package com.hao.easy.mvvm.android.repository

import com.hao.easy.mvvm.android.model.Article
import com.hao.easy.mvvm.android.model.Type
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.model.HttpResult
import com.hao.easy.mvvm.base.model.ListPaged
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

    @GET("project/tree/json")
    fun getProjectType(): Observable<HttpResult<ArrayList<Type>>>

    @GET("article/listproject/{page}/json")
    fun getNewArticles(@Path("page") page: Int): Observable<HttpResult<ListPaged<Article>>>

    @GET("project/list/{page}/json")
    fun getArticles(@Path("page") page: Int, @Query("cid") cid: Int): Observable<HttpResult<ListPaged<Article>>>

    @POST("lg/collect/{id}/json")
    fun collect(@Path("id") id: Int): Observable<HttpResult<Void>>

    @POST("lg/uncollect_originId/{id}/json")
    fun cancelCollect(@Path("id") id: Int): Observable<HttpResult<Void>>
}