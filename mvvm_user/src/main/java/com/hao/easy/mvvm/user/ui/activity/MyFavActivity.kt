package com.hao.easy.mvvm.user.ui.activity

import android.view.View
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.ui.BaseListActivity
import com.hao.easy.mvvm.base.ui.WebActivity
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.di.component.DaggerActivityComponent
import com.hao.easy.mvvm.user.model.Fav
import com.hao.easy.mvvm.user.ui.adapter.MyFavAdapter
import com.hao.easy.mvvm.user.viewmodel.MyFavViewModel
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/12/3
 */
class MyFavActivity : BaseListActivity<Fav, MyFavViewModel>() {

    @Inject
    lateinit var adapter: MyFavAdapter

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

    override fun itemClicked(view: View, item: Fav, position: Int) {
        if (view.id == R.id.buttonDelete) {
            viewModel.cancelCollect(item, position)
        } else {
            WebActivity.start(this, item.title, item.link)
        }
    }
}