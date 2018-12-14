package com.hao.easy.mvvm.wechat.ui.fragment

import android.view.View
import com.hao.easy.mvvm.base.ui.BaseListFragment
import com.hao.easy.mvvm.base.ui.WebActivity
import com.hao.easy.mvvm.wechat.R
import com.hao.easy.mvvm.wechat.di.component
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.ui.adapter.KotlinArticleAdapter
import com.hao.easy.mvvm.wechat.viewmodel.KotlinViewModel
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class FlutterFragment : BaseListFragment<Article, KotlinViewModel>() {

    @Inject
    lateinit var adapter: KotlinArticleAdapter

    companion object {
        private const val TAG = "KotlinFragment"
    }

    override fun getLayoutId() = R.layout.wechat_fragment_flutter

    override fun isLazy() = true

    override fun adapter() = adapter

    override fun initInject() {
        component().inject(this)
    }

    override fun initData() {
        viewModel.key = "flutter"
        super.initData()
    }

    override fun itemClicked(view: View, item: Article, position: Int) {
        if (view.id == R.id.ivFav) {
            if (item.collect) {
                viewModel.cancelCollect(item, position)
            } else {
                viewModel.collect(item, position)
            }
        } else {
            context?.apply {
                var title = item.title.replace(Regex("<[^>]+>"), "")
                WebActivity.start(this, title, item.link)
            }
        }
    }
}