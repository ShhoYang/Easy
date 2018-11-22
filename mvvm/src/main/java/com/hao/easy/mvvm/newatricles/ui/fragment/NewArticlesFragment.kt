package com.hao.easy.mvvm.wechat.ui.fragment

import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseListFragment
import com.hao.easy.mvvm.newatricles.model.NewArticle
import com.hao.easy.mvvm.newatricles.ui.adapter.NewArticlesAdapter
import com.hao.easy.mvvm.newatricles.viewmodel.NewArticlesViewModel
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class NewArticlesFragment : BaseListFragment<NewArticle>() {

    @Inject
    lateinit var adapter: NewArticlesAdapter

    @Inject
    lateinit var viewModel: NewArticlesViewModel

    override fun getLayoutId() = R.layout.fragment_new_articles

    override fun initInject() {
        fragmentComponent().inject(this)
    }

    override fun dataViewModel() = viewModel

    override fun adapter() = adapter
}