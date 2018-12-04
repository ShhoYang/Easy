package com.hao.easy.mvvm.flutter.ui.fragment

import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.flutter.R

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class FlutterFragment : BaseFragment() {
    companion object {
        private const val TAG = "FlutterFragment"
    }
    override fun getLayoutId() = R.layout.flutter_fragment_flutter

    override fun isLazy() = true
}