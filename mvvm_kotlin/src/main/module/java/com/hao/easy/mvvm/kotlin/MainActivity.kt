package com.hao.easy.mvvm.kotlin

import com.hao.easy.mvvm.base.ui.ContainerActivity
import com.hao.easy.mvvm.kotlin.ui.fragment.KotlinFragment

/**
 * @author Yang Shihao
 * @date 2018/11/26
 */
class MainActivity : ContainerActivity() {

    override fun showToolbar() = false

    override fun getFragment() = KotlinFragment()
}