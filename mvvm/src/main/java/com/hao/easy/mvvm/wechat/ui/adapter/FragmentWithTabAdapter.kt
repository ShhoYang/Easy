package com.hao.easy.mvvm.wechat.ui.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.hao.easy.mvvm.common.FragmentCreator

/**
 * @author Yang Shihao
 * @date 2018/11/21
 */
class FragmentWithTabAdapter(fm: FragmentManager, var data: List<Pair<String, FragmentCreator>>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int) = data[position].second.create()

    override fun getCount() = data.size

    override fun getPageTitle(position: Int) = data[position].first
}
