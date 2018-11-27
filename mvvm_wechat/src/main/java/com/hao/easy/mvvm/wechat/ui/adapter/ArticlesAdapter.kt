package com.hao.easy.mvvm.wechat.ui.adapter

import com.hao.easy.mvvm.base.adapter.BasePagedAdapter
import com.hao.easy.mvvm.base.adapter.ViewHolder
import com.hao.easy.mvvm.wechat.R
import com.hao.easy.mvvm.wechat.model.Article
import javax.inject.Inject

class ArticlesAdapter @Inject constructor() : BasePagedAdapter<Article>(R.layout.item_wechat_articels) {

    override fun bindViewHolder(holder: ViewHolder, item: Article, position: Int) {
        holder.setText(R.id.tv_text, item.title)
    }
}


