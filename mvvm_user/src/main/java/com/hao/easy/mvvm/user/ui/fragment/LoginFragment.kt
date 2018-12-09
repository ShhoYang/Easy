package com.hao.easy.mvvm.user.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.text.TextUtils
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.extensions.addTextChangedListener
import com.hao.easy.mvvm.base.extensions.hideSoftInput
import com.hao.easy.mvvm.base.extensions.showError
import com.hao.easy.mvvm.base.extensions.snack
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.Router
import com.hao.easy.mvvm.user.di.inject
import com.hao.easy.mvvm.user.ui.activity.LoginActivity
import com.hao.easy.mvvm.user.viewmodel.LoginViewModel
import com.socks.library.KLog
import kotlinx.android.synthetic.main.user_fragment_login.*
import retrofit2.Retrofit
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
    lateinit var retrofit: Retrofit

    lateinit var viewModel: LoginViewModel

    override fun getLayoutId() = R.layout.user_fragment_login

    override fun onAttach(context: Context?) {
        inject()
        super.onAttach(context)
    }

    override fun initView() {
        KLog.d(TAG, "initView ${retrofit.toString()}")
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
            viewModel.login(username, password)
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
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.loginLiveData.observe(this, Observer {
            if (it == null) {
                Router.startMainActivity()
                activity?.finish()
            } else {
                editTextUsername.snack(it)
            }
        })
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            activity?.title = "登录"
        }
    }
}
