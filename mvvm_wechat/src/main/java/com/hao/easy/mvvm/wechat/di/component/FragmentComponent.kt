package com.hao.easy.mvvm.inject.component

import com.hao.easy.mvvm.inject.PreFragment
import com.hao.easy.mvvm.wechat.ui.fragment.ArticlesFragment
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreFragment
@Component(dependencies = [AppComponent::class])
interface FragmentComponent {

    fun inject(articlesFragment: ArticlesFragment)
}