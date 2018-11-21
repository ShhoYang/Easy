package com.hao.easy.mvvm.third.ui.fragment

import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_third.*

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class ThirdFragment : BaseFragment() {
    override fun getLayoutId() = R.layout.fragment_third

    override fun initView() {
        textView.text = "發現"
    }
}