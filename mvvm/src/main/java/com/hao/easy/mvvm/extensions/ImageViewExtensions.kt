package com.hao.easy.mvvm.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * @author Yang Shihao
 * @date 2018/11/22
 */

fun ImageView.load(url: Any) {
    Glide.with(this).load(url).into(this)
}