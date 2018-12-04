package com.hao.easy.mvvm.kotlin.ui.fragment

import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.kotlin.R

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class KotlinFragment : BaseFragment() {

    companion object {
        private const val TAG = "KotlinFragment"
    }

    override fun getLayoutId() = R.layout.kotlin_fragment_kotlin

    override fun isLazy() = true
}