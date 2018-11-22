package com.hao.easy.mvvm.base.ui

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.adapter.BaseItem
import com.hao.easy.mvvm.base.adapter.BasePagedAdapter
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.extensions.init
import com.socks.library.KLog
import org.jetbrains.anko.toast

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
abstract class BaseListFragment<T : BaseItem> : BaseFragment() {

    companion object {
        private const val TAG = "BaseListFragment"
    }

    var refreshLayout: SwipeRefreshLayout? = null

    lateinit var recyclerView: RecyclerView

    private var isCreated = false
    private var isVisibleToUser = false

    override fun getLayoutId() = R.layout.activity_base_list

    override fun initView() {
        refreshLayout = f(R.id.baseRefreshLayout)
        recyclerView = f(R.id.baseRecyclerView)!!
        recyclerView.init(adapter())
        refreshLayout?.setOnRefreshListener {
            dataViewModel().invalidate()
        }
    }

    override fun initData() {
        if (isLazy()) {
            isCreated = true
            lazyLoad()
        } else {
            doLoad()
        }
    }

    open fun isLazy() = false

    private fun lazyLoad() {
        if (isCreated && isVisibleToUser) {
            doLoad()
            isCreated = false
        }
    }

    open fun doLoad() {
        dataViewModel().observe(this,
                { adapter().submitList(it) },
                { refreshFinished(it) },
                { loadMoreFinished(it) })
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            this.isVisibleToUser = true
            lazyLoad()
        }
    }

    /**
     * @param success true:刷新完成  false:刷新失败  null:加载完成,沒有更多
     */
    open fun refreshFinished(success: Boolean?) {
        refreshLayout?.isRefreshing = false
    }

    /**
     * @param success true:加载完成  false:加载失败  null:加载完成,沒有更多
     */
    fun loadMoreFinished(success: Boolean?) {
        if (success == null) {
            context?.toast("全部加载完成")
        }
    }

    abstract fun adapter(): BasePagedAdapter<T>

    abstract fun dataViewModel(): BaseListViewModel<T>
}