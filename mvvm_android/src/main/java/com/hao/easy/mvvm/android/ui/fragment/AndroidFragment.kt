package com.hao.easy.mvvm.android.ui.fragment

import android.arch.lifecycle.Observer
import android.support.design.widget.AppBarLayout
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.hao.easy.mvvm.android.R
import com.hao.easy.mvvm.android.di.component.DaggerFragmentComponent
import com.hao.easy.mvvm.android.model.Article
import com.hao.easy.mvvm.android.ui.adapter.ArticleAdapter
import com.hao.easy.mvvm.android.ui.adapter.TypeAdapter
import com.hao.easy.mvvm.android.viewmodel.AndroidViewModel
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.ui.BaseListFragment
import com.hao.easy.mvvm.base.ui.WebWithImageActivity
import kotlinx.android.synthetic.main.fragment_android.*
import org.jetbrains.anko.support.v4.dimen
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class AndroidFragment : BaseListFragment<Article, AndroidViewModel>() {

    companion object {
        private const val TAG = "AndroidFragment"
    }

    @Inject
    lateinit var adapter: ArticleAdapter

    @Inject
    lateinit var typeAdapter: TypeAdapter

    override fun getLayoutId() = R.layout.fragment_android

    override fun initInject() {
        DaggerFragmentComponent.builder()
                .appComponent(App.instance.appComponent)
                .build().inject(this)
    }

    override fun initView() {
        super.initView()
        rvType.apply {
            layoutManager = GridLayoutManager(context, 4)
            adapter = typeAdapter
        }
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            baseRefreshLayout.isEnabled = verticalOffset == 0
        })
    }

    override fun initData() {
        super.initData()
        viewModel.typeLiveData.observe(this, Observer {
            typeAdapter.setData(it!!)
        })
    }

    override fun adapter() = adapter

    override fun itemClicked(view: View, item: Article, position: Int) {
        context?.apply { WebWithImageActivity.start(this, item.title, item.link) }
    }
}