package com.hao.easy.mvvm.user.ui.activity

import com.hao.easy.mvvm.base.ui.BaseActivity
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.ui.fragment.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun showToolbar() = false

    override fun getLayoutId() = R.layout.activity_main

    override fun initView() {
        supportFragmentManager.beginTransaction()
                .add(R.id.frameLayout, UserFragment())
                .commit()
    }

    override fun onStop() {
        drawerLayout.closeDrawers()
        super.onStop()
    }
}

