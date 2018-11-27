package com.hao.easy.mvvm.android.ui.adapter

import com.hao.easy.mvvm.android.R
import com.hao.easy.mvvm.android.model.Article
import com.hao.easy.mvvm.base.adapter.BasePagedAdapter
import com.hao.easy.mvvm.base.adapter.ViewHolder
import javax.inject.Inject

class ArticleAdapter @Inject constructor() : BasePagedAdapter<Article>(R.layout.item_android_article) {

    override fun bindViewHolder(holder: ViewHolder, item: Article, position: Int) {
        holder.setText(R.id.tv_text, item.title)
    }
}


