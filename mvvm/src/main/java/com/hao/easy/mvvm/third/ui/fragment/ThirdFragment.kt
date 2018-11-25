package com.hao.easy.mvvm.third.ui.fragment

import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.socks.library.KLog

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class ThirdFragment : BaseFragment() {
    companion object {
        private const val TAG = "ThirdFragment"
    }
    override fun getLayoutId() = R.layout.fragment_third

    override fun initView() {
    }

    override fun isLazy() = true

    override fun initData() {
        super.initData()
        KLog.d(TAG, "initData")
    }
}