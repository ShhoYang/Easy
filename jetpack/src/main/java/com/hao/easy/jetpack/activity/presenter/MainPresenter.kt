package com.hao.easy.jetpack.activity.presenter

import com.hao.easy.jetpack.activity.constract.MainContract
import com.hao.easy.jetpack.http.doSubscribe
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * @author Yang Shihao
 * @date 2018/11/17
 */
class MainPresenter : MainContract.Presenter() {

    companion object {
        private val TAG = "MainPresenter"
    }

    override fun getData() {
        view?.showDialog()
        Observable.create(ObservableOnSubscribe<String> { emitter ->
            emitter.onNext("ok")
            //emitter.onError(Throwable("e"))
        })

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .delaySubscription(3, TimeUnit.SECONDS)
                .doSubscribe(
                        {
                            view?.apply {
                                setData(it)
                                dismissDialog()
                            }
                        },
                        {
                            view?.apply {
                                setData(it)
                                dismissDialog()
                            }
                        }
                )

    }
}
