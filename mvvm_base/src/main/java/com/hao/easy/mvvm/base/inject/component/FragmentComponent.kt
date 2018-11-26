package com.hao.easy.mvvm.inject.component

import com.hao.easy.mvvm.inject.PreFragment
import com.hao.easy.mvvm.inject.module.FragmentModule
import dagger.Subcomponent

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreFragment
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {

//    fun inject(loginFragment: LoginFragment)
//
//    fun inject(wechatFragment: WechatFragment)
//
//    fun inject(wechatArticlesFragment: WechatArticlesFragment)
//
//    fun inject(articlesFragment: NewArticlesFragment)
}