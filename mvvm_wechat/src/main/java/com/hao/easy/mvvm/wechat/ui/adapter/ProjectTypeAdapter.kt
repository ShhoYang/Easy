package com.hao.easy.mvvm.wechat.ui.adapter

import com.hao.easy.mvvm.base.adapter.BaseNormalAdapter
import com.hao.easy.mvvm.base.adapter.ViewHolder
import com.hao.easy.mvvm.base.common.Icon
import com.hao.easy.mvvm.wechat.R
import com.hao.easy.mvvm.wechat.model.ProjectType
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/12/2
 */
class ProjectTypeAdapter @Inject constructor() : BaseNormalAdapter<ProjectType>(R.layout.wechat_item_project_type) {

    override fun bindViewHolder(holder: ViewHolder, item: ProjectType, position: Int) {
        holder.visible(R.id.tvText)
                .setText(R.id.tvText, item.name?.replace("amp;", ""))
                .setImageResource(R.id.ivIcon, Icon.icons[position % 18])

    }
}