package com.hao.easy.mvvm.base.extensions

import com.hao.easy.mvvm.base.model.HttpResult
import com.socks.library.KLog
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <D, T : HttpResult<D>> Observable<T>.subscribeBy(onResponse: (D?) -> Unit) =
        subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.errorCode == 0) {
                        onResponse(it.data)
                    }
                }, {
                    KLog.d("onFailure", it)
                })

fun <D, T : HttpResult<D>> Observable<T>.subscribeBy(onResponse: (D?) -> Unit, onFailure: (String) -> Unit) =
        subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.errorCode == 0) {
                        onResponse(it.data)
                    } else {
                        onFailure(it.errorMsg)
                    }
                }, {
                    onFailure(it.message!!)
                })

fun <D, T : HttpResult<D>> Observable<T>._subscribeBy(onResponse: (D?) -> Unit) =
        observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.errorCode == 0) {
                        onResponse(it.data)
                    }
                }, {
                    KLog.d("onFailure", it)
                })

fun <D, T : HttpResult<D>> Observable<T>._subscribeBy(onResponse: (D?) -> Unit, onFailure: (String) -> Unit) =
        observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.errorCode == 0) {
                        onResponse(it.data)
                    } else {
                        onFailure(it.errorMsg)
                    }
                }, {
                    onFailure(it.message!!)
                })

