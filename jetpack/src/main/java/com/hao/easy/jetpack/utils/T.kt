package com.hao.easy.jetpack.utils

import android.content.Context
import android.widget.Toast

/**
 * @author Yang Shihao
 * @date 2018/11/17
 */
object T {

    fun toast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}
