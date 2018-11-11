package com.hao.easy.sharedelement.image

import android.graphics.Bitmap

/**
 * @author Yang Shihao
 */
object BitmapThumbnail {

    var key: String? = null
    var bitmap: Bitmap? = null

    fun clear() {
        key = null
        bitmap = null
    }
}