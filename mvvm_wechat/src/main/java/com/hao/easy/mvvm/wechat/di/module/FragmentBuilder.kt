package com.hao.easy.mvvm.wechat.di.module

import com.hao.easy.mvvm.wechat.ui.fragment.ProjectFragment
import com.hao.easy.mvvm.wechat.ui.fragment.WechatArticleFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * @author Yang Shihao
 * @date 2018/12/7
 */

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindWechatArticleFragment(): WechatArticleFragment

    @ContributesAndroidInjector
    internal abstract fun bindProjectFragment(): ProjectFragment

}