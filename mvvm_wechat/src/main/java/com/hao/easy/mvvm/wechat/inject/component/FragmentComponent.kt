package com.hao.easy.mvvm.inject.component

import com.hao.easy.mvvm.inject.PreFragment
import com.hao.easy.mvvm.inject.module.FragmentModule
import com.hao.easy.mvvm.wechat.ui.fragment.ArticlesFragment
import com.hao.easy.mvvm.wechat.ui.fragment.WechatFragment
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreFragment
@Component(modules = [FragmentModule::class], dependencies = [AppComponent::class])
interface FragmentComponent {

    fun inject(wechatFragment: WechatFragment)

    fun inject(wechatArticlesFragment: ArticlesFragment)
}