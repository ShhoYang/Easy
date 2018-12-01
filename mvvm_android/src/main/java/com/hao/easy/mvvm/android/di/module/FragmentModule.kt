package com.hao.easy.mvvm.android.di.module

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.hao.easy.mvvm.android.repository.Api
import com.hao.easy.mvvm.android.viewmodel.ArticleViewModel
import com.hao.easy.mvvm.inject.module.FragmentCommonModule
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@Module(includes = [FragmentCommonModule::class])
class FragmentModule {

    @Provides
    internal fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @Provides
    internal fun provideArticleViewModel(fragment: Fragment, api: Api): ArticleViewModel {
        val viewModel = ViewModelProviders.of(fragment).get(ArticleViewModel::class.java)
        viewModel.api = api
        return viewModel
    }
}