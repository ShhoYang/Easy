package com.hao.easy.extensions

import android.view.View

/**
 * @author Yang Shihao
 */

fun <T : View> View.f(id: Int): T {
    return findViewById<T>(id)
}