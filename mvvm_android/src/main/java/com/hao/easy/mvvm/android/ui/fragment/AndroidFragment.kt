package com.hao.easy.mvvm.android.ui.fragment

import android.view.View
import com.hao.easy.mvvm.android.R
import com.hao.easy.mvvm.android.di.component.DaggerFragmentComponent
import com.hao.easy.mvvm.android.di.module.FragmentModule
import com.hao.easy.mvvm.android.model.Article
import com.hao.easy.mvvm.android.ui.adapter.ArticleAdapter
import com.hao.easy.mvvm.android.viewmodel.ArticleViewModel
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.ui.BaseListFragment
import com.hao.easy.mvvm.base.ui.WebWithImageActivity
import com.hao.easy.mvvm.inject.module.FragmentCommonModule
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class AndroidFragment : BaseListFragment<Article>() {

    companion object {
        private const val TAG = "AndroidFragment"
    }

    @Inject
    lateinit var adapter: ArticleAdapter

    @Inject
    lateinit var viewModel: ArticleViewModel

    override fun getLayoutId() = R.layout.fragment_android

    override fun initInject() {
        DaggerFragmentComponent.builder()
                .appComponent(App.instance.appComponent)
                .fragmentCommonModule(FragmentCommonModule(this))
                .fragmentModule(FragmentModule())
                .build().inject(this)
    }

    override fun dataViewModel() = viewModel

    override fun adapter() = adapter

    override fun itemClicked(view: View, item: Article, position: Int) {
        context?.apply { WebWithImageActivity.start(this, item.title, item.link) }
    }
}