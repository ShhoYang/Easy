package com.hao.easy.mvvm.first.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.first.ui.adapter.FirstAdapter
import com.hao.easy.mvvm.base.BaseFragment
import com.hao.easy.mvvm.extensions.init
import com.hao.easy.mvvm.first.model.Article
import com.hao.easy.mvvm.first.viewmodel.FirstViewModel
import kotlinx.android.synthetic.main.fragment_first.*
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class FirstFragment : BaseFragment() {

    @Inject
    lateinit var mainAdapter: FirstAdapter

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(FirstViewModel::class.java)
    }

    override fun getLayoutId() = R.layout.fragment_first

    override fun initInject() {
        fragmentComponent().inject(this)

    }

    override fun initView() {
        viewModel.liveData.observe(this, Observer<PagedList<Article>> { t -> mainAdapter.submitList(t) })
        recyclerView.init(mainAdapter)
    }
}