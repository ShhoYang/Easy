package com.hao.easy.mvvm.inject.component

import com.hao.easy.mvvm.inject.PreFragment
import com.hao.easy.mvvm.wechat.ui.fragment.ProjectFragment
import com.hao.easy.mvvm.wechat.ui.fragment.WechatArticleFragment
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreFragment
@Component(dependencies = [AppComponent::class])
interface FragmentComponent {

    fun inject(wechatArticleFragment: WechatArticleFragment)

    fun inject(projectFragment: ProjectFragment)
}