package com.hao.easy.mvvm.base.ui

import android.support.v4.app.Fragment
import com.hao.easy.mvvm.base.R

abstract class ContainerActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_container

    override fun initView() {
        supportFragmentManager.beginTransaction()
                .add(R.id.frameLayout, getFragment())
                .commit()
    }

    abstract fun getFragment(): Fragment
}
