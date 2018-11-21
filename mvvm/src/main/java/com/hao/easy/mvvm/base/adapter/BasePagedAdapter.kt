package com.hao.easy.mvvm.base.adapter

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.socks.library.KLog

abstract class BasePagedAdapter<T : BaseItem>(private val layoutId: Int) : PagedListAdapter<T, ViewHolder>(Diff<T>()) {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(context, parent, layoutId)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindViewHolder(holder, getItem(position)!!, position)
    }

    class Diff<T : BaseItem> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(item: T, item1: T) = item.id == item1.id

        override fun areContentsTheSame(item: T, item1: T) = item == item1
    }

    override fun getItemCount(): Int {
        var itemCount = super.getItemCount()
        //KLog.d("BaseListFragment", "getItemCount--$itemCount")
        return itemCount
    }

    abstract fun bindViewHolder(holder: ViewHolder, item: T, position: Int)
}