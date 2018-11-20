package com.hao.easy.mvvm.first.ui.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.first.model.Article
import org.jetbrains.anko.toast
import javax.inject.Inject

class FirstAdapter @Inject constructor() : PagedListAdapter<Article, FirstAdapter.ViewHolder>(diff) {

    companion object {
        val diff = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(p0: Article, p1: Article) = p0.id == p1.id

            override fun areContentsTheSame(p0: Article, p1: Article) = p0 == p1
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
            ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_first, p0, false))

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.textView.apply {
            text = getItem(p1)?.title
            setOnClickListener { context.toast("$p1/$itemCount") }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.tv_text)!!
    }
}


