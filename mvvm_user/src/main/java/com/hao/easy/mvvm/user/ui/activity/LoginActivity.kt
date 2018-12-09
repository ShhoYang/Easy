package com.hao.easy.mvvm.user.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.hao.easy.mvvm.base.ui.BaseActivity
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.di.inject
import com.hao.easy.mvvm.user.ui.fragment.LoginFragment
import com.hao.easy.mvvm.user.ui.fragment.RegisterFragment
import com.socks.library.KLog
import retrofit2.Retrofit
import javax.inject.Inject

@Route(path = "/user/LoginActivity")
class LoginActivity : BaseActivity() {

    private val loginFragment: LoginFragment by lazy { LoginFragment() }

    private val registerFragment: RegisterFragment by lazy { RegisterFragment() }

    @Inject
    lateinit var retrofit: Retrofit

    override fun showToolbar() = false

    override fun getLayoutId() = R.layout.user_activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        KLog.d("CCCCCCCCCCCCC", "initView ${retrofit.toString()}")
        supportFragmentManager
                .beginTransaction().apply {
                    add(R.id.frame, loginFragment, "Login")
                    commit()
                }
    }

    fun goRegister() {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                    R.anim.user_fragment_right_in,
                    R.anim.user_fragment_left_out,
                    R.anim.user_fragment_left_in,
                    R.anim.user_fragment_right_out
            )
            hide(loginFragment)
            add(R.id.frame, registerFragment, "Register")
            addToBackStack(null)
            commit()
        }
    }
}
