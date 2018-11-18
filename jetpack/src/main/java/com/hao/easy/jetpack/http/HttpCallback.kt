package com.hao.easy.jetpack.http

import com.hao.easy.jetpack.App
import com.hao.easy.jetpack.utils.T
import io.reactivex.functions.Consumer

/**
 * @author Yang Shihao
 * @date 2018/11/16
 */
class HttpResponse<T>(val onResponse: (T) -> Unit = {}, val onFailure: (String) -> Unit = {
    com.hao.easy.jetpack.utils.T.toast(App.instance, "数据为null")
}) : Consumer<T> {

    override fun accept(t: T?) {
        if (t == null) {
            onFailure("数据为null")
        } else {
            onResponse(t)
        }
    }
}

class HttpFailure(val onFailure: (String) -> Unit = {
    T.toast(App.instance, "网络出错")
}) : Consumer<Throwable> {

    override fun accept(t: Throwable?) {
        onFailure("连接失败")
    }
}