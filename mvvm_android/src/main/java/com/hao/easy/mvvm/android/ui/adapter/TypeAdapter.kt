package com.hao.easy.mvvm.android.ui.adapter

import com.hao.easy.mvvm.android.R
import com.hao.easy.mvvm.android.model.Type
import com.hao.easy.mvvm.base.adapter.BaseNormalAdapter
import com.hao.easy.mvvm.base.adapter.ViewHolder
import com.hao.easy.mvvm.base.common.Icon
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/12/2
 */
class TypeAdapter @Inject constructor() : BaseNormalAdapter<Type>(R.layout.android_item_type) {

    override fun bindViewHolder(holder: ViewHolder, item: Type, position: Int) {
        holder.visible(R.id.tvText)
                .setText(R.id.tvText, item.name?.replace("amp;", ""))
                .setImageResource(R.id.ivIcon, Icon.icons[position % 18])

    }
}