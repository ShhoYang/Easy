package com.hao.easy.mvvm.wechat.ui.fragment

import android.arch.lifecycle.Observer
import android.graphics.Color
import android.support.v4.app.Fragment
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.common.FragmentCreator
import com.hao.easy.mvvm.wechat.ui.adapter.FragmentWithTabAdapter
import com.hao.easy.mvvm.wechat.viewmodel.WeChatViewModel
import kotlinx.android.synthetic.main.fragment_we_chat.*
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class WeChatFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: WeChatViewModel

    override fun getLayoutId() = R.layout.fragment_we_chat

    override fun initInject() {
        fragmentComponent().inject(this)
    }

    override fun initView() {
        tabLayout.setupWithViewPager(viewPager)
        toolbarLayout.setCollapsedTitleTextColor(Color.WHITE)
        toolbarLayout.setExpandedTitleColor(Color.WHITE)
        toolbarLayout.title = "公众号"
    }

    override fun initData() {
        viewModel.authorsLiveData.observe(this, Observer { authors ->
           val data =  authors!!.map { author ->
                Pair<String, FragmentCreator>(author.name, object : FragmentCreator {
                    override fun create() = WeChatArticlesFragment.instance(author.id)
                })
            }

            viewPager.adapter = FragmentWithTabAdapter(childFragmentManager,data)
        })
        viewModel.initData()
    }
}