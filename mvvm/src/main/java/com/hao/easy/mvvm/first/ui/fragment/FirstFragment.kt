package com.hao.easy.mvvm.first.ui.fragment

import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseListFragment
import com.hao.easy.mvvm.first.model.Article
import com.hao.easy.mvvm.first.ui.adapter.FirstAdapter
import com.hao.easy.mvvm.first.viewmodel.FirstViewModel
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class FirstFragment : BaseListFragment<Article>() {

    @Inject
    lateinit var firstAdapter: FirstAdapter

    @Inject
    lateinit var viewModel: FirstViewModel

    override fun getLayoutId() = R.layout.fragment_first

    override fun initInject() {
        fragmentComponent().inject(this)
    }

    override fun dataViewModel() = viewModel

    override fun adapter() = firstAdapter
}