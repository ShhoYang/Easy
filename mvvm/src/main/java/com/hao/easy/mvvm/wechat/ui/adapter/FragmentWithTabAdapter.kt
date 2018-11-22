package com.hao.easy.mvvm.wechat.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup
import com.hao.easy.mvvm.common.FragmentCreator

/**
 * @author Yang Shihao
 * @date 2018/11/21
 */
class FragmentWithTabAdapter(fm: FragmentManager, var data: List<Pair<String, FragmentCreator>>) : FragmentPagerAdapter(fm) {

    var currentFragment: Fragment? = null

    override fun getItem(position: Int) = data[position].second.create()

    override fun getCount() = data.size

    override fun getPageTitle(position: Int) = data[position].first

    override fun setPrimaryItem(container: ViewGroup, position: Int, obj: Any) {
        currentFragment = obj as Fragment
        super.setPrimaryItem(container, position, obj)
    }
}
