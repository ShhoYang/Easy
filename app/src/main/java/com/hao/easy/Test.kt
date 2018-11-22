package com.hao.easy

import android.graphics.Bitmap


fun main(args: Array<String>) {
    test(null)
}

fun test(bitmap: Bitmap?) {
    if (bitmap == null) {
        throw NullPointerException("bitmap is null")
    }
}


