package com.hao.easy.jetpack.activity.ui

import com.hao.easy.jetpack.R
import com.hao.easy.jetpack.activity.constract.MainContract
import com.hao.easy.jetpack.activity.presenter.MainPresenter
import com.hao.easy.jetpack.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View {

    lateinit var mainPresenter: MainPresenter

    override fun getLayoutId() = R.layout.activity_main


    override fun initInject() {
        mainPresenter = MainPresenter()
        mainPresenter.attachView(this)
        lifecycle.addObserver(mainPresenter)

    }

    override fun initView() {
    }

    override fun initData() {
        mainPresenter.getData()
    }

    override fun setData(string: String) {
        textView.text = string
    }
}
