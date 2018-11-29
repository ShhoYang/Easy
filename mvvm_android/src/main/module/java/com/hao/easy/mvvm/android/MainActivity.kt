package com.hao.easy.mvvm.android

import com.hao.easy.mvvm.android.ui.fragment.AndroidFragment
import com.hao.easy.mvvm.base.ui.ContainerActivity


/**
 * @author Yang Shihao
 * @date 2018/11/26
 */
class MainActivity : ContainerActivity() {

    override fun showToolbar() = false

    override fun getFragment() = AndroidFragment()
}