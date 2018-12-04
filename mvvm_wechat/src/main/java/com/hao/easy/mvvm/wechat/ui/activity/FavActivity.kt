package com.hao.easy.mvvm.wechat.ui.activity

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.ui.BaseListActivity
import com.hao.easy.mvvm.base.ui.WebActivity
import com.hao.easy.mvvm.wechat.R
import com.hao.easy.mvvm.wechat.di.component.DaggerActivityComponent
import com.hao.easy.mvvm.wechat.model.Article
import com.hao.easy.mvvm.wechat.ui.adapter.FavAdapter
import com.hao.easy.mvvm.wechat.viewmodel.FavViewModel
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/12/3
 */

@Route(path = "/wechat/FavActivity")
class FavActivity : BaseListActivity<Article, FavViewModel>() {

    @Inject
    lateinit var adapter: FavAdapter

    override fun initInject() {
        DaggerActivityComponent.builder()
                .appComponent(App.instance.appComponent)
                .build().inject(this)
    }

    override fun initView() {
        super.initView()
        title = "我的收藏"
    }

    override fun adapter() = adapter

    override fun itemClicked(view: View, item: Article, position: Int) {
        if (view.id == R.id.buttonDelete) {
            viewModel.cancelCollect(item, position)
        } else {
            WebActivity.start(this, item.title, item.link)
        }
    }
}