package com.hao.easy.mvvm.base.ui

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.adapter.BaseItem
import com.hao.easy.mvvm.base.adapter.BasePagedAdapter
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.extensions.init
import com.socks.library.KLog

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
abstract class BaseListFragment<T : BaseItem> : BaseFragment() {

    companion object {
        private const val TAG = "BaseListFragment"
    }

    lateinit var refreshLayout: SwipeRefreshLayout

    lateinit var recyclerView: RecyclerView

    override fun initView() {
        refreshLayout = f(R.id.baseRefreshView)
        recyclerView = f(R.id.baseRecyclerView)
        dataViewModel().observe(this,
                { adapter().submitList(it) },
                { refreshFinished(it) },
                { loadMoreFinished(it) })
        recyclerView.init(adapter())
        refreshLayout.setOnRefreshListener {
            dataViewModel().invalidate()
        }
    }

    fun refreshFinished(success: Boolean) {
        refreshLayout.isRefreshing = false
        KLog.d(TAG, "refreshFinished--$success--${adapter().itemCount}")

    }

    fun loadMoreFinished(success: Boolean) {
        KLog.d(TAG, "loadMoreFinished--$success")
    }

    abstract fun adapter(): BasePagedAdapter<T>

    abstract fun dataViewModel(): BaseListViewModel<T>
}