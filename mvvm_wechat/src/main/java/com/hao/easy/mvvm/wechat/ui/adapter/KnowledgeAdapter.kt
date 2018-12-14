package com.hao.easy.mvvm.wechat.ui.adapter

import com.hao.easy.mvvm.base.adapter.BaseNormalAdapter
import com.hao.easy.mvvm.base.adapter.BasePagedAdapter
import com.hao.easy.mvvm.base.adapter.ViewHolder
import com.hao.easy.mvvm.base.common.Icon
import com.hao.easy.mvvm.base.extensions.init
import com.hao.easy.mvvm.wechat.R
import com.hao.easy.mvvm.wechat.model.Knowledge
import com.hao.easy.mvvm.wechat.ui.activity.KnowledgeArticleActivity
import com.library.flowlayout.FlowLayoutManager
import com.library.flowlayout.NestedRecyclerView
import javax.inject.Inject
import kotlin.random.Random

/**
 * @author Yang Shihao
 * @date 2018/12/3
 */
class KnowledgeAdapter @Inject constructor() : BasePagedAdapter<Knowledge>(R.layout.wechat_item_knowledge_group) {

    override fun bindViewHolder(holder: ViewHolder, item: Knowledge, position: Int) {
        holder.setText(R.id.tvGroupName, item.name)
        var flowAdapter = FlowAdapter(item.children)
        var flowLayout = holder.getView<NestedRecyclerView>(R.id.flowLayout)
        flowLayout.init(flowAdapter, FlowLayoutManager())
    }
}

class FlowAdapter(data: ArrayList<Knowledge>) : BaseNormalAdapter<Knowledge>(R.layout.wechat_item_knowledge_child, data) {

    override fun bindViewHolder(holder: ViewHolder, item: Knowledge, position: Int) {
        holder.setText(R.id.tvChildName, item.name)
                .setImageResource(R.id.ivIcon, Icon.icons[Random.nextInt(Icon.icons.size)])
                .itemView.setOnClickListener {
            KnowledgeArticleActivity.start(context, item)

        }
    }
}