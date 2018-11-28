package com.hao.easy.mvvm.user.http

import com.hao.easy.mvvm.base.model.HttpResult
import com.hao.easy.mvvm.base.model.User
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
}