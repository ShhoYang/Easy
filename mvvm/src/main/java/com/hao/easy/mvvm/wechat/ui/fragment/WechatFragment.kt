package com.hao.easy.mvvm.wechat.ui.fragment

import android.arch.lifecycle.Observer
import android.support.design.widget.AppBarLayout
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.common.FragmentCreator
import com.hao.easy.mvvm.wechat.ui.adapter.FragmentWithTabAdapter
import com.hao.easy.mvvm.wechat.viewmodel.WechatViewModel
import kotlinx.android.synthetic.main.fragment_wechat.*
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class WechatFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: WechatViewModel
    private var adapter: FragmentWithTabAdapter? = null

    private var startX = .0F
    private var startY = .0F

    override fun getLayoutId() = R.layout.fragment_wechat

    override fun initInject() {
        fragmentComponent().inject(this)
    }

    override fun initView() {

        baseRefreshLayout.setOnRefreshListener {
            var weChatArticlesFragment = adapter?.currentFragment as WechatArticlesFragment
            if (weChatArticlesFragment == null) {
                baseRefreshLayout.isRefreshing = false
            } else {
                weChatArticlesFragment.refresh()
            }
        }

        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener {
            _, verticalOffset ->
            baseRefreshLayout.isEnabled = verticalOffset == 0
        })

        tabLayout.setupWithViewPager(viewPager)

    }

    override fun initData() {
        viewModel.authorsLiveData.observe(this, Observer { authors ->
            val data = authors!!.map { author ->
                Pair<String, FragmentCreator>(author.name, object : FragmentCreator {
                    override fun create() = WechatArticlesFragment.instance(author.id)
                })
            }
            adapter = FragmentWithTabAdapter(childFragmentManager, data)
            viewPager.adapter = adapter
        })
        viewModel.initData()
    }

    fun refreshFinished() {
        baseRefreshLayout.isRefreshing = false
    }
}