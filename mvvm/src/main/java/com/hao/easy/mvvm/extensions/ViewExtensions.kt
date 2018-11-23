package com.hao.easy.mvvm.extensions

import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.View

/**
 * @author Yang Shihao
 * @date 2018/11/20
 */

fun <VH : RecyclerView.ViewHolder, A : Adapter<VH>> RecyclerView.init(adapter: A, layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)) {
    this.layoutManager = layoutManager
    this.adapter = adapter
}

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.visible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.visibility(visible: Boolean) {
    if (visible) {
        visible()
    } else {
        gone()
    }
}

fun View.snack(msg: String) {
    Snackbar.make(this, msg, Snackbar.LENGTH_SHORT).show()
}
