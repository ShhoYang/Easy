package com.hao.easy.mvvm.wechat.ui.activity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseActivity
import com.hao.easy.mvvm.wechat.ui.fragment.WechatFragment
import com.hao.easy.mvvm.fourth.ui.fragment.FourthFragment
import com.hao.easy.mvvm.third.ui.fragment.ThirdFragment
import com.hao.easy.mvvm.wechat.ui.fragment.NewArticlesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_main

    override fun initView() {

        viewPager.apply {
            offscreenPageLimit = 3
            adapter = MainViewPagerAdapter(supportFragmentManager)
        }

        navigationView.setOnNavigationItemSelectedListener { item ->
            viewPager.currentItem =
                    when (item.itemId) {
                        R.id.tab_wechat -> 0
                        R.id.tab_new -> 1
                        R.id.tab_android -> 2
                        else -> 3
                    }
            true
        }
    }

    inner class MainViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getItem(p0: Int): Fragment {
            return when (p0) {
                0 -> WechatFragment()
                1 -> NewArticlesFragment()
                2 -> ThirdFragment()
                else -> FourthFragment()
            }
        }

        override fun getCount() = 4
    }
}
