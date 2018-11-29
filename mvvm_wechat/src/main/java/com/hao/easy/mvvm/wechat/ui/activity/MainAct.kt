package com.hao.easy.mvvm.wechat.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.hao.easy.mvvm.base.ui.BaseActivity
import com.hao.easy.mvvm.wechat.R

@Route(path = "/wechat/MainAct")
class MainAct : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_wechat
    }
}
