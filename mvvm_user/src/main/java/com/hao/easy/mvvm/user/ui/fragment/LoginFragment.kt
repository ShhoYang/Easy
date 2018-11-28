package com.hao.easy.mvvm.user.ui.fragment

import android.text.TextUtils
import com.hao.easy.mvvm.base.extensions.addTextChangedListener
import com.hao.easy.mvvm.base.extensions.hideSoftInput
import com.hao.easy.mvvm.base.extensions.showError
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.ui.activity.LoginActivity
import com.hao.easy.mvvm.user.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/25
 */
class LoginFragment : BaseFragment() {

    companion object {
        private const val TAG = "LoginFragment"
    }

    @Inject
    lateinit var viewMode: LoginViewModel

    override fun getLayoutId() = R.layout.fragment_login

    override fun initInject() {

    }

    override fun initView() {

        editTextUsername.addTextChangedListener(textInputUsername)
        editTextPassword.addTextChangedListener(textInputPassword)
        buttonLogin.setOnClickListener {
            var username = editTextUsername.text.toString().trim()
            var password = editTextPassword.text.toString().trim()
            if (TextUtils.isEmpty(username)) {
                textInputUsername.showError("用户名不能为空")
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(password)) {
                textInputPassword.showError("密码不能为空")
                return@setOnClickListener
            }
            viewMode.login(username, password)
            hideSoftInput()
        }
        textRegister.setOnClickListener {
            activity?.let { act ->
                val a = act as LoginActivity
                a.goRegister()
            }
        }
    }

    override fun initData() {
//        viewMode.loggedLiveData.observe(this, Observer {
//            if (it == null) {
//                startActivity<MainActivity>()
//            }else {
//                editTextUsername.snack(it)
//            }
//        })
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            activity?.title = "登录"
        }
    }
}
