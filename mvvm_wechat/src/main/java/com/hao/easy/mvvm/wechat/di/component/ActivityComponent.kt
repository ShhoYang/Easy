package com.hao.easy.mvvm.wechat.di.component

import com.hao.easy.mvvm.inject.PreActivity
import com.hao.easy.mvvm.inject.component.AppComponent
import com.hao.easy.mvvm.wechat.ui.activity.FavActivity
import com.hao.easy.mvvm.wechat.ui.activity.ProjectArticleActivity
import dagger.Component

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreActivity
@Component(dependencies = [AppComponent::class])
interface ActivityComponent {

    fun inject(projectArticleActivity: ProjectArticleActivity)

    fun inject(favActivity: FavActivity)
}