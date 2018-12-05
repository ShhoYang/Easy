package com.hao.easy.mvvm.wechat.ui.fragment

import android.os.Bundle
import android.view.View
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.common.RefreshResult
import com.hao.easy.mvvm.base.ui.BaseListFragment
import com.hao.easy.mvvm.base.ui.WebActivity
import com.hao.easy.mvvm.inject.component.DaggerFragmentComponent
import com.hao.easy.mvvm.wechat.R
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.ui.adapter.WechatArticleAdapter
import com.hao.easy.mvvm.wechat.viewmodel.WechatArticleViewModel
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class WechatArticleFragment : BaseListFragment<Article, WechatArticleViewModel>() {

    companion object {
        private const val AUTHOR_ID = "AUTHOR_ID"
        fun instance(authorId: Int): WechatArticleFragment {
            val fragment = WechatArticleFragment()
            val bundle = Bundle()
            bundle.putInt(AUTHOR_ID, authorId)
            fragment.arguments = bundle
            return fragment
        }
    }

    @Inject
    lateinit var adapter: WechatArticleAdapter

    override fun getLayoutId() = R.layout.wechat_fragment_wechat_article

    override fun initInject() {
        DaggerFragmentComponent.builder()
                .appComponent(App.instance.appComponent)
                .build()
                .inject(this)
    }

    override fun isLazy() = true

    override fun initData() {
        arguments?.apply {
            viewModel.authorId = getInt(AUTHOR_ID, 409)
        }
        super.initData()
    }

    override fun adapter() = adapter

    override fun itemClicked(view: View, item: Article, position: Int) {
        if (view.id == R.id.ivFav) {
            if (item.collect) {
                viewModel.cancelCollect(item, position)
            } else {
                viewModel.collect(item, position)
            }
        } else {
            context?.apply { WebActivity.start(this, item.title, item.link) }
        }
    }

    override fun refreshFinished(result: RefreshResult) {
        super.refreshFinished(result)
        var weChatFragment = parentFragment as WechatFragment
        weChatFragment.refreshFinished()
    }

    fun refresh() {
        viewModel.invalidate()
    }
}