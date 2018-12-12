package com.hao.easy.mvvm.wechat.di.component

import com.hao.easy.mvvm.base.di.component.AppComponent
import com.hao.easy.mvvm.inject.ActivityScope
import com.hao.easy.mvvm.wechat.ui.activity.FavActivity
import com.hao.easy.mvvm.wechat.ui.activity.ProjectArticleActivity
import dagger.Component


/**
 * @author Yang Shihao
 * @date 2018/12/7
 */

@ActivityScope
@Component(dependencies = [AppComponent::class])
interface ActivityComponent {
    fun inject(projectArticleActivity: ProjectArticleActivity)

    fun inject(favActivity: FavActivity)
}