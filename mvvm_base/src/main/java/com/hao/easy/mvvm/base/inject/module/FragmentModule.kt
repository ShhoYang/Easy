package com.hao.easy.mvvm.inject.module

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v4.app.Fragment
import com.hao.easy.mvvm.base.http.Api
import com.hao.easy.mvvm.inject.ActivityContext
import dagger.Module
import dagger.Provides

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    internal fun provideFragment(): Fragment {
        return fragment
    }

    @Provides
    internal fun provideActivity(): Activity? {
        return fragment.activity
    }

    @Provides
    @ActivityContext
    internal fun provideContext(): Context? {
        return fragment.context
    }

//    @Provides
//    internal fun provideLoginViewModel(api: Api): LoginViewModel {
//        val viewModel = ViewModelProviders.of(fragment).get(LoginViewModel::class.java)
//        viewModel.api = api
//        return viewModel
//    }
//
//    @Provides
//    internal fun provideWechatViewModel(api: Api): WechatViewModel {
//        val viewModel = ViewModelProviders.of(fragment).get(WechatViewModel::class.java)
//        viewModel.api = api
//        return viewModel
//    }
//
//    @Provides
//    internal fun provideWechatArticlesViewModel(api: Api): WechatArticlesViewModel {
//        val viewModel = ViewModelProviders.of(fragment).get(WechatArticlesViewModel::class.java)
//        viewModel.api = api
//        return viewModel
//    }
//
//    @Provides
//    internal fun provideNewArticlesViewModel(api: Api): NewArticlesViewModel {
//        val viewModel = ViewModelProviders.of(fragment).get(NewArticlesViewModel::class.java)
//        viewModel.api = api
//        return viewModel
//    }
}