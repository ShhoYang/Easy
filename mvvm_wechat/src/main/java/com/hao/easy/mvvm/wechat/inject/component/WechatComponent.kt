package com.hao.easy.mvvm.inject.component

import com.hao.easy.mvvm.inject.PreFragment
import com.hao.easy.mvvm.wechat.inject.module.WechatModule
import com.hao.easy.mvvm.wechat.ui.fragment.ArticlesFragment
import com.hao.easy.mvvm.wechat.ui.fragment.WechatFragment
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreFragment
@Component(modules = [WechatModule::class], dependencies = [AppComponent::class])
interface WechatComponent {

    fun inject(wechatFragment: WechatFragment)

    fun inject(articlesFragment: ArticlesFragment)
}