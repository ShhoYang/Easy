package com.hao.easy.mvvm.android.ui.adapter

import android.view.View
import com.hao.easy.mvvm.android.R
import com.hao.easy.mvvm.android.model.Article
import com.hao.easy.mvvm.base.adapter.BasePagedAdapter
import com.hao.easy.mvvm.base.adapter.ViewHolder
import javax.inject.Inject

class ArticleAdapter @Inject constructor() : BasePagedAdapter<Article>(R.layout.android_item_article) {

    override fun bindViewHolder(holder: ViewHolder, item: Article, position: Int) {

        var click: (View) -> Unit = {
            itemClickListener?.apply {
                this(it, item, position)
            }
        }
        holder.setText(R.id.tvTitle, item.title)
                .setText(R.id.tvDesc, item.desc)
                .setText(R.id.tvTime, item.niceDate)
                .setImageResource(R.id.ivFav, if (item.collect) R.drawable.ic_fav_1 else R.drawable.ic_fav_0)
                .setImage(R.id.ivThumbnail, item.envelopePic)
                .setClickListener(arrayOf(R.id.ivLink, R.id.tvLink, R.id.ivFav), click)
    }
}


