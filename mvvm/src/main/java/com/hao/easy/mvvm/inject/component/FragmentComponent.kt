package com.hao.easy.mvvm.inject.component

import com.hao.easy.mvvm.wechat.ui.fragment.WeChatFragment
import com.hao.easy.mvvm.inject.PreFragment
import com.hao.easy.mvvm.inject.module.FragmentModule
import com.hao.easy.mvvm.wechat.ui.fragment.NewArticlesFragment
import com.hao.easy.mvvm.wechat.ui.fragment.WeChatArticlesFragment
import dagger.Subcomponent

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreFragment
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(weChatFragment: WeChatFragment)

    fun inject(weChatArticlesFragment: WeChatArticlesFragment)

    fun inject(newArticlesFragment: NewArticlesFragment)
}