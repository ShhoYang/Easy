package com.hao.easy.mvvm.fourth.ui.fragment

import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.socks.library.KLog
import kotlinx.android.synthetic.main.toolbar.*

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class FourthFragment : BaseFragment() {

    companion object {
        private const val TAG = "FourthFragment"
    }

    override fun getLayoutId() = R.layout.fragment_fourth

    override fun initView() {
    }

    override fun isLazy() = true

    override fun initData() {
        super.initData()
        KLog.d(TAG, "initData")
    }
}