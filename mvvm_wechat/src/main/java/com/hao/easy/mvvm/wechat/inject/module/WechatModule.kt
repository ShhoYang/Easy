package com.hao.easy.mvvm.wechat.inject.module

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.hao.easy.mvvm.inject.module.FragmentCommonModule
import com.hao.easy.mvvm.wechat.http.Api
import com.hao.easy.mvvm.wechat.viewmodel.ArticlesViewModel
import com.hao.easy.mvvm.wechat.viewmodel.WechatViewModel
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [FragmentCommonModule::class])
class WechatModule {

    @Provides
    internal fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @Provides
    internal fun provideWechatViewModel(api: Api, fragment: Fragment): WechatViewModel {
        val viewModel = ViewModelProviders.of(fragment).get(WechatViewModel::class.java)
        viewModel.api = api
        return viewModel
    }

    @Provides
    internal fun provideArticlesViewModel(api: Api, fragment: Fragment): ArticlesViewModel {
        val viewModel = ViewModelProviders.of(fragment).get(ArticlesViewModel::class.java)
        viewModel.api = api
        return viewModel
    }
}