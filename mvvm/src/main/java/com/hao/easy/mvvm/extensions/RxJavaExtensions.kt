package com.hao.easy.mvvm.extensions

import com.hao.easy.mvvm.base.model.HttpResult
import com.hao.easy.mvvm.base.http.HttpFailure
import com.hao.easy.mvvm.base.http.HttpResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <D, T : HttpResult<D>> Observable<T>.map_main(): Observable<D> =
        map { it.data }.observeOn(AndroidSchedulers.mainThread())

fun <D, T : HttpResult<D>> Observable<T>.map_io_main(): Observable<D> =
        map { it.data }.io_main()

fun <T> Observable<T>.io_main(): Observable<T> =
        subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.doSubscribe() {
    doSubscribe({}, {})
}

fun <T> Observable<T>.doSubscribe(onResponse: (T) -> Unit) {
    doSubscribe(onResponse, {})
}

fun <T> Observable<T>.doSubscribeForFailure(onFailure: (String) -> Unit) {
    doSubscribe({}, onFailure)
}

fun <T> Observable<T>.doSubscribe(onResponse: (T) -> Unit, onFailure: (String) -> Unit) {
    subscribe(HttpResponse(onResponse, onFailure), HttpFailure(onFailure))
}
