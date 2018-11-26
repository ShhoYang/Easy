package com.hao.easy.mvvm.activity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.widget.DrawerLayout
import android.view.View
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.extensions.snack
import com.hao.easy.mvvm.base.ui.BaseActivity
import com.hao.easy.mvvm.flutter.ui.fragment.FlutterFragment
import com.hao.easy.mvvm.kotlin.ui.ffragment.KotlinFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates


class MainActivity : BaseActivity() {

    private var drawerOpened: Boolean = false

    private var backPressedTime by Delegates.observable(0L) { _, old, new ->
        if (new - old < 2000) {
            finish()
        } else {
            drawerLayout?.snack("再按返回鍵退出")
        }
    }

    override fun showToolbar() = false

    override fun getLayoutId() = R.layout.activity_main

    override fun initView() {
        initDrawerLayout()
        initLeftNavigation()
        initBottomNavigation()
        viewPager.apply {
            offscreenPageLimit = 3
            adapter = MainViewPagerAdapter(supportFragmentManager)
        }
    }

    private fun initDrawerLayout() {
        drawerLayout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {

            override fun onDrawerClosed(p0: View) {
                drawerOpened = false
            }

            override fun onDrawerOpened(p0: View) {
                drawerOpened = true
            }

        })
    }

    private fun initLeftNavigation() {

    }

    private fun initBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            viewPager.currentItem =
                    when (item.itemId) {
                        R.id.tab_wechat -> 0
                        R.id.tab_new -> 1
                        R.id.tab_android -> 0
                        else -> 1
                    }
            true
        }
    }

    override fun onBackPressed() {
        if (drawerOpened) {
            drawerLayout.closeDrawers()
        } else {
            backPressedTime = System.currentTimeMillis()
        }
    }

    inner class MainViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getItem(p0: Int): Fragment {
            return when (p0) {
                0 -> FlutterFragment()
                else -> KotlinFragment()
            }
        }

        override fun getCount() = 2
    }
}
