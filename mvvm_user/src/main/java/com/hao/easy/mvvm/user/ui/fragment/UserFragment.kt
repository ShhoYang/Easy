package com.hao.easy.mvvm.user.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.widget.TextView
import com.alibaba.android.arouter.launcher.ARouter
import com.hao.easy.mvvm.base.Config
import com.hao.easy.mvvm.base.extensions.snack
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.base.ui.WebActivity
import com.hao.easy.mvvm.base.user.User
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.ui.activity.LoginActivity
import com.hao.easy.mvvm.user.ui.activity.MyFavActivity
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

    override fun getLayoutId() = R.layout.fragment_user

    override fun initView() {
        tvUsername = leftNavigationView.getHeaderView(0).find(R.id.tvUsername)
        leftNavigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_fav -> {
                    if (Config.instance().isLogin) {
                        startActivity<MyFavActivity>()
                    } else {
                        ARouter.getInstance().build("/user/LoginActivity").navigation()
                    }
                }
                R.id.menu_clear -> {
                    leftNavigationView.snack("清理完成")
                }
                R.id.menu_about -> {
                    WebActivity.start(context!!, "https://github.com/haoshiy", "https://github.com/haoshiy")
                }
                R.id.menu_logout -> {
                    Config.instance().logout()
                    viewModel.logout()
                }
            }
            true
        }
    }

    override fun initData() {
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        lifecycle.addObserver(viewModel)
        viewModel.loginLiveData.observe(this, Observer {
            serLogin(it)
        })
        viewModel.logoutLiveData.observe(this, Observer {
            if (it == null) {
                goLogin()
            }
        })
    }

    private fun serLogin(user: User?) {
        if (user == null) {
            tvUsername.text = "未登录"
            tvUsername.setOnClickListener {
                goLogin()
            }
            leftNavigationView.menu.findItem(R.id.menu_logout).isVisible = false

        } else {
            tvUsername.text = user.username
            tvUsername.setOnClickListener(null)
            leftNavigationView.menu.findItem(R.id.menu_logout).isVisible = true
        }
    }

    private fun goLogin() {
        startActivity<LoginActivity>()
    }
}