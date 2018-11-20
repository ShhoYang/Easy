package com.hao.easy.mvvm.http

import com.hao.easy.mvvm.extensions.map
import com.hao.easy.mvvm.first.model.ArticleList
import com.socks.library.KLog
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Yang Shihao
 * @date 2018/11/19
 */
class Api {

    private val loggingInterceptor: HttpLoggingInterceptor by lazy {
        var interceptor = HttpLoggingInterceptor {
            KLog.json("json________", it)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        interceptor
    }

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

    private val weChatApiService: ApiService = retrofit.create(ApiService::class.java)

    fun getArticleList(page: Int = 1): Observable<ArticleList> {
        return weChatApiService.getArticleList(409, page).map()
    }
}