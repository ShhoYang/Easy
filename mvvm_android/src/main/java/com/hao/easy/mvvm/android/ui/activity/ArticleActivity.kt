package com.hao.easy.mvvm.android.ui.activity

import android.content.Context
import com.hao.easy.mvvm.android.di.component.DaggerActivityComponent
import com.hao.easy.mvvm.android.model.Article
import com.hao.easy.mvvm.android.model.Type
import com.hao.easy.mvvm.android.ui.adapter.ArticleAdapter
import com.hao.easy.mvvm.android.viewmodel.ArticleViewModel
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.ui.BaseListActivity
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class ArticleActivity : BaseListActivity<Article, ArticleViewModel>() {

    @Inject
    lateinit var adapter: ArticleAdapter

    companion object {
        private const val TYPE = "TYPE"
        fun start(context: Context, type: Type) {
            context.startActivity<ArticleActivity>(Pair(TYPE, type))
        }
    }

    override fun initInject() {
        DaggerActivityComponent.builder()
                .appComponent(App.instance.appComponent)
                .build().inject(this)
    }

    override fun initData() {
        var type = intent.getParcelableExtra<Type>(TYPE)
        type?.apply {
            title = name
            viewModel.typeId = id
        }

        super.initData()
    }

    override fun adapter() = adapter
}
