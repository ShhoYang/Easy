package com.hao.easy.mvvm.user.ui.activity

import com.hao.easy.mvvm.base.ui.BaseActivity
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.ui.fragment.LoginFragment
import com.hao.easy.mvvm.user.ui.fragment.RegisterFragment

class LoginActivity : BaseActivity() {

    private val loginFragment: LoginFragment by lazy { LoginFragment() }
    private val registerFragment: RegisterFragment by lazy { RegisterFragment() }

    override fun showToolbar() = false

    override fun getLayoutId() = R.layout.activity_login

    override fun initView() {
        supportFragmentManager
                .beginTransaction().apply {
                    add(R.id.frame, loginFragment, "Login")
                    commit()
                }

    }

    fun goRegister() {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                    R.anim.fragment_right_in,
                    R.anim.fragment_left_out,
                    R.anim.fragment_left_in,
                    R.anim.fragment_right_out
            )
            hide(loginFragment)
            add(R.id.frame, registerFragment, "Register")
            addToBackStack(null)
            commit()
        }
    }
}
