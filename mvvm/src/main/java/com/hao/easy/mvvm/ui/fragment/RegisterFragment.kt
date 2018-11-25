package com.hao.easy.mvvm.ui.fragment

import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_register.*

/**
 * @author Yang Shihao
 * @date 2018/11/25
 */
class RegisterFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_register

    override fun initView() {
        activity?.title = "注册"
        textLogin.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }
}
