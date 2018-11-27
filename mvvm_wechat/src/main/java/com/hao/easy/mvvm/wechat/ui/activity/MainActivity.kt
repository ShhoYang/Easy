package com.hao.easy.mvvm.wechat.ui.activity

import com.hao.easy.mvvm.base.ui.ContainerActivity
import com.hao.easy.mvvm.wechat.ui.fragment.WechatFragment

/**
 * @author Yang Shihao
 * @date 2018/11/26
 */
class MainActivity : ContainerActivity() {

    override fun showToolbar() = false

    override fun getFragment() = WechatFragment()
}