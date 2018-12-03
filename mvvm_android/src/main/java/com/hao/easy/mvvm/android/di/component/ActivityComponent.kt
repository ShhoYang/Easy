package com.hao.easy.mvvm.android.di.component

import com.hao.easy.mvvm.android.ui.activity.ArticleActivity
import com.hao.easy.mvvm.inject.PreActivity
import com.hao.easy.mvvm.inject.component.AppComponent
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreActivity
@Component(dependencies = [AppComponent::class])
interface ActivityComponent {

    fun inject(articleActivity: ArticleActivity)
}