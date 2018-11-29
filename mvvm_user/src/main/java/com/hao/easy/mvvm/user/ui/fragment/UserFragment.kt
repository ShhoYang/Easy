package com.hao.easy.mvvm.user.ui.fragment

import android.support.v4.widget.DrawerLayout
import com.hao.easy.mvvm.base.extensions.snack
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.ui.activity.LoginActivity
import com.socks.library.KLog
import kotlinx.android.synthetic.main.fragment_user.*
import org.jetbrains.anko.support.v4.startActivity


/**
 * @author Yang Shihao
 * @date 2018/11/28
 */
class UserFragment : BaseFragment() {

    companion object {
        private const val TAG = "UserFragment"
    }

    override fun getLayoutId() = R.layout.fragment_user

    override fun initView() {
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
                    startActivity<LoginActivity>()
                }
            }
            true
        }
    }

    private fun closeDrawers() {
        var drawerLayout = leftNavigationView.parent.parent
        if (drawerLayout is DrawerLayout) {
            drawerLayout.closeDrawers()
        }
    }
}