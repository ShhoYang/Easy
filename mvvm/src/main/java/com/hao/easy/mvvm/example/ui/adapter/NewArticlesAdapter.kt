package com.hao.easy.mvvm.example.ui.adapter

import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.adapter.BasePagedAdapter
import com.hao.easy.mvvm.base.adapter.ViewHolder
import com.hao.easy.mvvm.example.model.NewArticle
import javax.inject.Inject

class NewArticlesAdapter @Inject constructor() : BasePagedAdapter<NewArticle>(R.layout.item_first) {

    override fun bindViewHolder(holder: ViewHolder, item: NewArticle, position: Int) {
        holder.setText(R.id.tv_text, item.title)
    }
}


