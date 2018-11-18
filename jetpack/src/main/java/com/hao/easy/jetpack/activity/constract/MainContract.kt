package com.hao.easy.jetpack.activity.constract

import com.hao.easy.jetpack.base.AbsPresenter
import com.hao.easy.jetpack.base.IView

/**
 * @author Yang Shihao
 * @date 2018/11/16
 */
interface MainContract {

    interface View : IView {

        fun setData(string: String)
    }

    abstract class Presenter : AbsPresenter<View>() {

        abstract fun getData()
    }
}
