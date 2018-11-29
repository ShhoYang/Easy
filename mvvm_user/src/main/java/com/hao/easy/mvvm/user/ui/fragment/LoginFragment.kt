package com.hao.easy.mvvm.user.ui.fragment

import android.arch.lifecycle.Observer
import android.text.TextUtils
import com.alibaba.android.arouter.launcher.ARouter
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.extensions.addTextChangedListener
import com.hao.easy.mvvm.base.extensions.hideSoftInput
import com.hao.easy.mvvm.base.extensions.showError
import com.hao.easy.mvvm.base.extensions.snack
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.inject.module.FragmentCommonModule
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.UserApp
import com.hao.easy.mvvm.user.http.Api
import com.hao.easy.mvvm.user.inject.component.DaggerFragmentComponent
import com.hao.easy.mvvm.user.inject.module.FragmentModule
import com.hao.easy.mvvm.user.ui.activity.LoginActivity
import com.hao.easy.mvvm.user.viewmodel.LoginViewModel
import com.socks.library.KLog
import kotlinx.android.synthetic.main.fragment_login.*
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
    lateinit var viewMode: LoginViewModel

//    @Inject
//    lateinit var retrofit: Retrofit
//
    @Inject
    lateinit var api: Api

    override fun getLayoutId() = R.layout.fragment_login

    override fun initInject() {
        DaggerFragmentComponent.builder()
                .apiComponent(UserApp.apiComponent)
                .fragmentCommonModule(FragmentCommonModule(this))
                .fragmentModule(FragmentModule())
                .build().inject(this)
    }

    override fun initView() {
//        KLog.d(TAG, "initView  retrofit = ${retrofit.hashCode()}")
        KLog.d(TAG, "initView  retrofit  api = ${api.hashCode()}")
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
                ARouter.getInstance().build("/app/MainActivity").navigation()
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
