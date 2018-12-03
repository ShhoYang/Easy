package com.hao.easy.mvvm.user.ui.adapter

import com.hao.easy.mvvm.base.adapter.BasePagedAdapter
import com.hao.easy.mvvm.base.adapter.ViewHolder
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.model.Fav
import com.mcxtzhang.swipemenulib.SwipeMenuLayout
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/12/3
 */
class MyFavAdapter @Inject constructor() : BasePagedAdapter<Fav>(R.layout.user_item_fav) {

    override fun bindViewHolder(holder: ViewHolder, item: Fav, position: Int) {
        (holder.itemView as SwipeMenuLayout).isIos = false//这句话关掉IOS阻塞式交互效果
        holder.setText(R.id.tvTitle, item.title)
                .setClickListener(R.id.buttonDelete) {
                    itemClickListener?.apply {
                        (holder.itemView as SwipeMenuLayout).quickClose()
                        this(it, item, position)
                    }
                }
    }
}