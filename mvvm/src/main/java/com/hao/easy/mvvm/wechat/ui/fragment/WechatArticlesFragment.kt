package com.hao.easy.mvvm.wechat.ui.fragment

import android.os.Bundle
import android.view.View
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseListFragment
import com.hao.easy.mvvm.ui.activity.WebActivity
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.ui.adapter.WechatArticlesAdapter
import com.hao.easy.mvvm.wechat.viewmodel.WechatArticlesViewModel
import com.socks.library.KLog
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class WechatArticlesFragment : BaseListFragment<Article>() {

    companion object {
        private const val TAG = "WechatArticlesFragment"
        private const val AUTHOR_ID = "AUTHOR_ID"
        fun instance(authorId: Int): WechatArticlesFragment {
            val fragment = WechatArticlesFragment()
            val bundle = Bundle()
            bundle.putInt(AUTHOR_ID, authorId)
            fragment.arguments = bundle
            return fragment
        }
    }

    @Inject
    lateinit var adapter: WechatArticlesAdapter

    @Inject
    lateinit var viewModel: WechatArticlesViewModel

    override fun getLayoutId() = R.layout.fragment_wechat_articles

    override fun initInject() {
        fragmentComponent().inject(this)
    }

    override fun initData() {
        KLog.d(TAG, "initData")
        arguments?.apply {
            viewModel.authorId = getInt(AUTHOR_ID, 409)
        }
        super.initData()
    }

    override fun dataViewModel() = viewModel

    override fun adapter() = adapter

    override fun itemClicked(view: View, item: Article, position: Int) {
        context?.apply { WebActivity.start(this, item.title, item.link) }
    }

    override fun refreshFinished(success: Boolean?) {
        super.refreshFinished(success)
        var weChatFragment = parentFragment as WechatFragment
        weChatFragment?.refreshFinished()
    }

    fun refresh() {
        viewModel.invalidate()
    }
}