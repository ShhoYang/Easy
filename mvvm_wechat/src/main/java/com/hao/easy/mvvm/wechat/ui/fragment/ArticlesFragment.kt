package com.hao.easy.mvvm.wechat.ui.fragment

import android.os.Bundle
import android.view.View
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.ui.BaseListFragment
import com.hao.easy.mvvm.base.ui.WebActivity
import com.hao.easy.mvvm.inject.component.DaggerFragmentComponent
import com.hao.easy.mvvm.wechat.R
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.ui.adapter.ArticlesAdapter
import com.hao.easy.mvvm.wechat.viewmodel.ArticlesViewModel
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class ArticlesFragment : BaseListFragment<Article,ArticlesViewModel>() {

    companion object {
        private const val TAG = "ArticlesFragment"
        private const val AUTHOR_ID = "AUTHOR_ID"
        fun instance(authorId: Int): ArticlesFragment {
            val fragment = ArticlesFragment()
            val bundle = Bundle()
            bundle.putInt(AUTHOR_ID, authorId)
            fragment.arguments = bundle
            return fragment
        }
    }

    @Inject
    lateinit var adapter: ArticlesAdapter

    override fun getLayoutId() = R.layout.wechat_fragment_articles

    override fun initInject() {
        DaggerFragmentComponent.builder()
                .appComponent(App.instance.appComponent)
                .build()
                .inject(this)
    }

    override fun initData() {
        arguments?.apply {
            viewModel.authorId = getInt(AUTHOR_ID, 409)
        }
        super.initData()
    }

    override fun adapter() = adapter

    override fun itemClicked(view: View, item: Article, position: Int) {
        if (view.id == R.id.ivFav) {
            viewModel.collect(item, position)
        } else {
            context?.apply { WebActivity.start(this, item.title, item.link) }
        }
    }

    override fun refreshFinished(success: Boolean?) {
        super.refreshFinished(success)
        var weChatFragment = parentFragment as WechatFragment
        weChatFragment.refreshFinished()
    }

    fun refresh() {
        viewModel.invalidate()
    }
}