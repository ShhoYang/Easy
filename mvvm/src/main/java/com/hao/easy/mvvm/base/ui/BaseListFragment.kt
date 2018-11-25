package com.hao.easy.mvvm.base.ui

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.adapter.BaseItem
import com.hao.easy.mvvm.base.adapter.BasePagedAdapter
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.extensions.init
import com.hao.easy.mvvm.extensions.snack
import com.hao.easy.mvvm.view.EmptyView

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
abstract class BaseListFragment<T : BaseItem> : BaseFragment() {

    companion object {
        private const val TAG = "BaseListFragment"
    }

    private var refreshLayout: SwipeRefreshLayout? = null
    private var emptyView: EmptyView? = null

    lateinit var recyclerView: RecyclerView

    override fun getLayoutId() = R.layout.activity_base_list

    override fun initView() {
        refreshLayout = f(R.id.baseRefreshLayout)
        recyclerView = f(R.id.baseRecyclerView)!!
        emptyView = f(R.id.baseEmptyView)
        var adapter = adapter()
        adapter.itemClickListener = { view, item, position ->
            itemClicked(view, item, position)
        }
        recyclerView.init(adapter)
        refreshLayout?.setOnRefreshListener {
            dataViewModel().invalidate()
        }
    }

    override fun initData() {
        dataViewModel().observe(this,
                { adapter().submitList(it) },
                { refreshFinished(it) },
                { loadMoreFinished(it) })
    }

    open fun itemClicked(view: View, item: T, position: Int) {

    }

    /**
     * @param success true:刷新完成  false:刷新失败  null:加载完成,沒有更多
     */
    open fun refreshFinished(success: Boolean?) {
        refreshLayout?.isRefreshing = false
        emptyView?.apply {
            if (success == null) {
                state = EmptyView.Status.NO_DATA
            }else if(success){
                state = EmptyView.Status.DISMISS
            }else {
                state = EmptyView.Status.LOAD_FAILED
            }
        }
    }

    /**
     * @param success true:加载完成  false:加载失败  null:加载完成,沒有更多
     */
    fun loadMoreFinished(success: Boolean?) {
        if (success == null) {
            recyclerView?.snack("全部加载完成")
        }
    }

    abstract fun adapter(): BasePagedAdapter<T>

    abstract fun dataViewModel(): BaseListViewModel<T>
}