package com.hao.easy.mvvm.user.repository

import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.model.HttpResult
import com.hao.easy.mvvm.base.model.ListPaged
import com.hao.easy.mvvm.base.user.User
import com.hao.easy.mvvm.user.model.Fav
import io.reactivex.Observable
import retrofit2.http.*

/**
 * @author Yang Shihao
 * @date 2018/11/19
 */

object Api : Service by App.instance.appComponent.retrofit().create(Service::class.java)

interface Service {

    @FormUrlEncoded
    @POST("user/register")
    fun register(@Field("username") username: String,
                 @Field("password") password: String,
                 @Field("repassword") confirmPassword: String): Observable<HttpResult<User>>

    @FormUrlEncoded
    @POST("user/login")
    fun login(@Field("username") username: String,
              @Field("password") password: String): Observable<HttpResult<User>>

    @GET("user/logout/json")
    fun logout(): Observable<HttpResult<User>>


    @GET("lg/collect/list/{page}/json")
    fun getMyFav(@Path("page") page:Int): Observable<HttpResult<ListPaged<Fav>>>

    @POST("lg/uncollect_originId/{id}/json")
    fun cancelCollect(@Path("id") id: Int): Observable<HttpResult<Void>>
}