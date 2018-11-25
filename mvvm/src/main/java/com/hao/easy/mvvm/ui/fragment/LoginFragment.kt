package com.hao.easy.mvvm.ui.fragment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.extensions.addTextChangedListener
import com.hao.easy.mvvm.extensions.hideSoftInput
import com.hao.easy.mvvm.extensions.showError
import com.hao.easy.mvvm.extensions.snack
import com.hao.easy.mvvm.ui.activity.LoginActivity
import com.hao.easy.mvvm.ui.activity.MainActivity
import com.hao.easy.mvvm.ui.viewmodel.LoginViewModel
import com.socks.library.KLog
import kotlinx.android.synthetic.main.fragment_login.*
import org.jetbrains.anko.support.v4.startActivity
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/25
 */
class LoginFragment : BaseFragment() {

    companion object {
        private const val TAG = "LoginFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        KLog.d(TAG, "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        KLog.d(TAG, "onActivityCreated")
    }

    @Inject
    lateinit var viewMode: LoginViewModel

    override fun getLayoutId() = R.layout.fragment_login

    override fun initInject() {
        fragmentComponent().inject(this)
    }

    override fun initView() {

        var parent = textInputUsername.getChildAt(0)
        KLog.d(TAG, "initView" + parent)

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
        viewMode.loggedLiveData.observe(this, Observer {
            if (it == null) {
                startActivity<MainActivity>()
            }else {
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
