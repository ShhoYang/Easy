package com.hao.easy.mvvm.user.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.text.TextUtils
import com.hao.easy.mvvm.base.extensions.addTextChangedListener
import com.hao.easy.mvvm.base.extensions.hideSoftInput
import com.hao.easy.mvvm.base.extensions.showError
import com.hao.easy.mvvm.base.extensions.snack
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.user_fragment_register.*

/**
 * @author Yang Shihao
 * @date 2018/11/25
 */
class RegisterFragment : BaseFragment() {

    lateinit var viewModel: RegisterViewModel

    override fun getLayoutId() = R.layout.user_fragment_register

    override fun initView() {
        activity?.title = "注册"
        editTextUsername.addTextChangedListener(textInputUsername)
        editTextPassword.addTextChangedListener(textInputPassword)
        editTextConfirmPassword.addTextChangedListener(textInputConfirmPassword)
        buttonRegister.setOnClickListener {
            var username = editTextUsername.text.toString().trim()
            var password = editTextPassword.text.toString().trim()
            var confirmPassword = editTextConfirmPassword.text.toString().trim()
            if (username.length < 6) {
                textInputUsername.showError("用户名6-16数字、字母")
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(password)) {
                textInputPassword.showError("密码6-16数字、字母")
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(confirmPassword)) {
                textInputConfirmPassword.showError("确认密码6-16数字、字母")
                return@setOnClickListener
            }
            if (password != confirmPassword) {
                textInputConfirmPassword.showError("确认密码与密码不符")
                return@setOnClickListener
            }
            viewModel.register(username, password)
            hideSoftInput()
        }
        textLogin.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    override fun initData() {
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        viewModel.registerLiveData.observe(this, Observer {
            if (it == null) {
                fragmentManager?.popBackStack()
            } else {
                editTextUsername.snack(it)
            }
        })
    }
}
