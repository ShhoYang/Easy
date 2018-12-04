package com.hao.easy.mvvm.base.ui

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import com.hao.easy.mvvm.base.R
import com.hao.easy.mvvm.base.adapter.BaseItem
import com.hao.easy.mvvm.base.adapter.BasePagedAdapter
import com.hao.easy.mvvm.base.common.RefreshResult
import com.hao.easy.mvvm.base.extensions.init
import com.hao.easy.mvvm.base.extensions.snack
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.view.EmptyView
import java.lang.reflect.ParameterizedType

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
abstract class BaseListActivity<T : BaseItem, VM : BaseListViewModel<T>> : BaseActivity() {

    companion object {
        private const val TAG = "BaseListFragment"
    }

    val viewModel: VM by lazy {
        var parameterizedType = javaClass.genericSuperclass as ParameterizedType
        val cla = parameterizedType.actualTypeArguments[1] as Class<VM>
        ViewModelProviders.of(this).get(cla)
    }

    private var refreshLayout: SwipeRefreshLayout? = null
    private var emptyView: EmptyView? = null

    lateinit var recyclerView: RecyclerView

    override fun getLayoutId() = R.layout.activity_base_list

    final override fun onInit() {
        super.onInit()
        lifecycle.addObserver(viewModel)
    }

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
            viewModel.invalidate()
        }
    }

    override fun initData() {
        viewModel.observeDataObserver(this,
                { adapter().submitList(it) },
                { refreshFinished(it) },
                { loadMoreFinished(it) })

        viewModel.observeAdapterObserver(this,
                {
                    if (it >= 0 && it < adapter().itemCount) {
                        adapter().notifyItemChanged(it)
                    }
                },
                {
                    if (it >= 0 && it < adapter().itemCount) {
                        adapter().currentList?.removeAt(it)
                        adapter().notifyItemRemoved(it)
                    }
                })
    }

    open fun itemClicked(view: View, item: T, position: Int) {

    }

    open fun refreshFinished(result: RefreshResult) {
        refreshLayout?.isRefreshing = false
        emptyView?.apply {
            when (result) {
                RefreshResult.SUCCEED -> state = EmptyView.Status.DISMISS
                RefreshResult.FAILED -> state = EmptyView.Status.LOAD_FAILED
                RefreshResult.NO_DATA -> state = EmptyView.Status.NO_DATA
                RefreshResult.NO_MORE -> {
                    state = EmptyView.Status.DISMISS
                    refreshLayout?.snack("全部加载完成")
                }
            }
        }
    }

    fun loadMoreFinished(result: RefreshResult) {
        when (result) {
            RefreshResult.SUCCEED -> {
            }
            RefreshResult.FAILED -> {
            }
            RefreshResult.NO_MORE -> refreshLayout?.snack("全部加载完成")
        }
    }

    abstract fun adapter(): BasePagedAdapter<T>
}