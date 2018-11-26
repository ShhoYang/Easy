package com.hao.easy.mvvm.flutter.ui.fragment

import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.flutter.R
import com.socks.library.KLog


/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class FlutterFragment : BaseFragment() {
    companion object {
        private const val TAG = "FlutterFragment"
    }
    override fun getLayoutId() = R.layout.fragment_flutter

    override fun initView() {
    }

    override fun isLazy() = true

    override fun initData() {
        super.initData()
        KLog.d(TAG, "initData")
    }
}