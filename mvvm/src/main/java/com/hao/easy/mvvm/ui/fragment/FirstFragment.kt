package com.hao.easy.mvvm.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.support.v7.widget.LinearLayoutManager
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.adapter.FirstAdapter
import com.hao.easy.mvvm.base.BaseFragment
import com.hao.easy.mvvm.model.Article
import com.hao.easy.mvvm.viewmodel.FirstViewModel
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class FirstFragment : BaseFragment() {

    private lateinit var mainAdapter: FirstAdapter

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(FirstViewModel::class.java)
    }

    override fun getLayoutId() = R.layout.fragment_first


    override fun initView() {

        mainAdapter = FirstAdapter()
        viewModel.liveData.observe(this, Observer<PagedList<Article>> { t -> mainAdapter.submitList(t) })
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = mainAdapter
        }
    }
}