package com.hao.easy.mvvm.user

import com.hao.easy.mvvm.base.ui.ContainerActivity
import com.hao.easy.mvvm.user.ui.fragment.UserFragment

class MainActivity : ContainerActivity() {

    override fun showToolbar() = false

    override fun getFragment() = UserFragment()
}

