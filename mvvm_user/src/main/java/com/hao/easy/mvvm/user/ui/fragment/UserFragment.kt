package com.hao.easy.mvvm.user.ui.fragment

import com.hao.easy.mvvm.base.extensions.snack
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.ui.activity.LoginActivity
import kotlinx.android.synthetic.main.fragment_user.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * @author Yang Shihao
 * @date 2018/11/28
 */
class UserFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_user

    override fun initView() {
        leftNavigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_collect -> {

                    true
                }
                R.id.menu_clear -> {
                    leftNavigationView.snack("清理完成")
                    true
                }
                R.id.menu_about -> {
                    true
                }
                R.id.menu_logout -> {
                    startActivity<LoginActivity>()
                    true
                }
                else -> false
            }
        }
    }
}