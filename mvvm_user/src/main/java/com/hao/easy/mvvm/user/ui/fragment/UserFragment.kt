package com.hao.easy.mvvm.user.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.text.TextUtils
import android.widget.TextView
import com.hao.easy.mvvm.base.Config
import com.hao.easy.mvvm.base.extensions.snack
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.ui.activity.LoginActivity
import com.hao.easy.mvvm.user.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_user.*
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.startActivity


/**
 * @author Yang Shihao
 * @date 2018/11/28
 */
class UserFragment : BaseFragment() {

    companion object {
        private const val TAG = "UserFragment"
    }

    lateinit var viewModel: UserViewModel

    private lateinit var tvUsername: TextView

    private var username: String = "未登录"


    override fun onStart() {
        super.onStart()
        username = Config.username
        if (TextUtils.isEmpty(username)) {
            tvUsername.text = "未登录"
            tvUsername.setOnClickListener {
                goLogin()
            }
            leftNavigationView.menu.findItem(R.id.menu_logout).isVisible = false
        } else {
            tvUsername.text = Config.username
            tvUsername.setOnClickListener(null)
            leftNavigationView.menu.findItem(R.id.menu_logout).isVisible = true
        }
    }

    override fun getLayoutId() = R.layout.fragment_user

    override fun initView() {
        tvUsername = leftNavigationView.getHeaderView(0).find(R.id.tvUsername)
        leftNavigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_collect -> {

                }
                R.id.menu_clear -> {
                    leftNavigationView.snack("清理完成")
                }
                R.id.menu_about -> {
                }
                R.id.menu_logout -> {
                    Config.logout()
                    viewModel.logout()
                }
            }
            true
        }
    }

    override fun initData() {
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        viewModel.logoutLiveData.observe(this, Observer {
            if (it == null) {
                goLogin()
            }
        })
    }

    private fun goLogin() {
        startActivity<LoginActivity>()
    }
}