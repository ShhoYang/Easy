package com.hao.easy.mvvm.base.http

import com.hao.easy.mvvm.common.App
import com.socks.library.KLog
import io.reactivex.functions.Consumer
import org.jetbrains.anko.toast

/**
 * @author Yang Shihao
 * @date 2018/11/16
 */
class HttpResponse<T>(val onResponse: (T) -> Unit = {}, val onFailure: (String) -> Unit = {
    App.instance.toast("数据为null")
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
    App.instance.toast("网络出错")
}) : Consumer<Throwable> {

    override fun accept(t: Throwable?) {
        t?.apply {
            KLog.d("HttpFailure", message)
        }
        onFailure("连接失败")
    }
}