package com.hao.easy.jetpack.base

import android.app.Activity

/**
 * @author Yang Shihao
 * @date 2018/11/16
 */
open interface IView {

    fun showDialog()

    fun showDialog(msg: String)

    fun dismissDialog()

    fun startActivity(cls: Class<in Activity>)

    fun toast(msg: String)

}