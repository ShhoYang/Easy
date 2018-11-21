package com.hao.easy.mvvm.wechat.ui.fragment

import android.os.Bundle
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseListFragment
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.ui.adapter.FirstAdapter
import com.hao.easy.mvvm.wechat.viewmodel.WeChatArticlesViewModel
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class WeChatArticlesFragment : BaseListFragment<Article>() {

    companion object {
        private const val AUTHOR_ID = "AUTHOR_ID"
        fun instance(authorId: Int): WeChatArticlesFragment {
            val fragment = WeChatArticlesFragment()
            val bundle = Bundle()
            bundle.putInt(AUTHOR_ID, authorId)
            fragment.arguments = bundle
            return fragment
        }
    }

    @Inject
    lateinit var adapter: FirstAdapter

    @Inject
    lateinit var viewModel: WeChatArticlesViewModel

    override fun getLayoutId() = R.layout.fragment_we_chat_articles

    override fun initInject() {
        fragmentComponent().inject(this)
    }

    override fun initData() {
        arguments?.apply { viewModel.authorId = getInt(AUTHOR_ID, 409) }
        super.initData()
    }

    override fun dataViewModel() = viewModel

    override fun adapter() = adapter
}