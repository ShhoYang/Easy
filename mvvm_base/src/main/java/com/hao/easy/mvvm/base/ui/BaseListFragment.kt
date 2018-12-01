package com.hao.easy.mvvm.base.ui

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import com.hao.easy.mvvm.base.R
import com.hao.easy.mvvm.base.adapter.BaseItem
import com.hao.easy.mvvm.base.adapter.BasePagedAdapter
import com.hao.easy.mvvm.base.extensions.init
import com.hao.easy.mvvm.base.extensions.snack
import com.hao.easy.mvvm.base.viewmodel.BaseListViewModel
import com.hao.easy.mvvm.view.EmptyView
import java.lang.reflect.ParameterizedType

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
abstract class BaseListFragment<T : BaseItem, VM : BaseListViewModel<T>> : BaseFragment() {

    companion object {
        private const val TAG = "BaseListFragment"
    }

    val dataViewModel: VM by lazy {
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
            dataViewModel.invalidate()
        }
    }

    override fun initData() {
        dataViewModel.observeDataObserver(this,
                { adapter().submitList(it) },
                { refreshFinished(it) },
                { loadMoreFinished(it) })

        dataViewModel.observeAdapterObserver(this,
                { adapter().notifyItemChanged(it) },
                { adapter().notifyItemRemoved(it) })
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
            } else if (success) {
                state = EmptyView.Status.DISMISS
            } else {
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
}