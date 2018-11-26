package com.hao.easy.mvvm.wechat.ui.fragment

import android.view.View
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseListFragment
import com.hao.easy.mvvm.example.model.NewArticle
import com.hao.easy.mvvm.example.ui.adapter.NewArticlesAdapter
import com.hao.easy.mvvm.example.viewmodel.NewArticlesViewModel
import com.hao.easy.mvvm.ui.activity.WebWithImageActivity
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class NewArticlesFragment : BaseListFragment<NewArticle>() {

    companion object {
        private const val TAG = "NewArticlesFragment"
    }

    @Inject
    lateinit var adapter: NewArticlesAdapter

    @Inject
    lateinit var viewModel: NewArticlesViewModel

    override fun getLayoutId() = R.layout.fragment_new_articles

    override fun initInject() {
        fragmentComponent().inject(this)
    }

    override fun isLazy() = true

    override fun dataViewModel() = viewModel

    override fun adapter() = adapter

    override fun itemClicked(view: View, item: NewArticle, position: Int) {
        context?.apply { WebWithImageActivity.start(this, item.title, item.link) }
    }
}