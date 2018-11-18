package com.hao.easy.jetpack.http

import io.reactivex.Observable

/**
 * @author Yang Shihao
 * @date 2018/11/17
 */

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

