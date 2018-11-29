package com.hao.easy.mvvm.flutter

import com.hao.easy.mvvm.base.ui.ContainerActivity
import com.hao.easy.mvvm.flutter.ui.fragment.FlutterFragment

/**
 * @author Yang Shihao
 * @date 2018/11/26
 */
class MainActivity : ContainerActivity() {

    override fun showToolbar() = false

    override fun getFragment()= FlutterFragment()
}