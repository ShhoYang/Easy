package com.hao.easy.mvvm.wechat.ui.adapter

import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.adapter.BasePagedAdapter
import com.hao.easy.mvvm.base.adapter.ViewHolder
import com.hao.easy.mvvm.wechat.model.Article
import org.jetbrains.anko.toast
import javax.inject.Inject

class FirstAdapter @Inject constructor() : BasePagedAdapter<Article>(R.layout.item_first) {

    override fun bindViewHolder(holder: ViewHolder, item: Article, position: Int) {
        holder.setText(R.id.tv_text, item.title)
                .setItemClickListener { context.toast("$position/$itemCount") }
    }
}


