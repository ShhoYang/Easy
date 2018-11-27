package com.hao.easy.mvvm.base.extensions

import com.hao.easy.mvvm.base.http.ApiException
import com.hao.easy.mvvm.base.model.HttpResult
import com.hao.easy.mvvm.base.http.HttpFailure
import com.hao.easy.mvvm.base.http.HttpResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <D, T : HttpResult<D>> Observable<T>.map_main(): Observable<D> =
        map { it.data }.observeOn(AndroidSchedulers.mainThread())

fun <D, T : HttpResult<D>> Observable<T>.map_io_main(): Observable<D> =
        map {
            if (it.errorCode != 0) {
                throw ApiException(it.errorMsg)
            }
            it.data
        }.io_main()

fun <T> Observable<T>.io_main(): Observable<T> =
        subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.subscribeBy() =
        subscribeBy({}, {})

fun <T> Observable<T>.subscribeBy(onResponse: (T) -> Unit) =
        subscribeBy(onResponse, {})

fun <T> Observable<T>.subscribeByFailure(onFailure: (String) -> Unit) =
        subscribeBy({}, onFailure)


fun <T> Observable<T>.subscribeBy(onResponse: (T) -> Unit, onFailure: (String) -> Unit) =
        subscribe(HttpResponse(onResponse, onFailure), HttpFailure(onFailure))

