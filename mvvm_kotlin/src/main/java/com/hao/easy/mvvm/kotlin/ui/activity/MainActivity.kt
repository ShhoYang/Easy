package com.hao.easy.mvvm.kotlin.ui.activity

import com.hao.easy.mvvm.base.ui.BaseActivity
import com.hao.easy.mvvm.kotlin.R
import com.hao.easy.mvvm.kotlin.ui.fragment.KotlinFragment

/**
 * @author Yang Shihao
 * @date 2018/11/26
 */
class MainActivity : BaseActivity() {

    override fun showToolbar() = false

    override fun getLayoutId() = R.layout.activity_main

    override fun initView() {
        supportFragmentManager.beginTransaction()
                .add(R.id.container, KotlinFragment())
                .commit()
    }

}