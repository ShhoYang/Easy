package com.hao.easy.mvvm.extensions

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

fun <T : View> View.f(id: Int): T {
    return findViewById(id)
}