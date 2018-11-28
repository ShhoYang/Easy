package com.hao.easy.mvvm.user.ui.fragment

import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.user.R
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
