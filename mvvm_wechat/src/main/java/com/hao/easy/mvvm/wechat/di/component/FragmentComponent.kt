package com.hao.easy.mvvm.wechat.di.component

import com.hao.easy.mvvm.base.di.component.AppComponent
import com.hao.easy.mvvm.inject.FragmentScope
import com.hao.easy.mvvm.wechat.ui.fragment.ProjectFragment
import com.hao.easy.mvvm.wechat.ui.fragment.WechatArticleFragment
import dagger.Component


/**
 * @author Yang Shihao
 * @date 2018/12/7
 */

@FragmentScope
@Component(dependencies = [AppComponent::class])
interface FragmentComponent {
    fun inject(wechatArticleFragment: WechatArticleFragment)

    fun inject(projectFragment: ProjectFragment)
}