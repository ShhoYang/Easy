package com.hao.easy.mvvm.user.inject.module

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.hao.easy.mvvm.inject.module.FragmentCommonModule
import com.hao.easy.mvvm.user.http.Api
import com.hao.easy.mvvm.user.viewmodel.LoginViewModel
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
    internal fun provideLoginViewModel(fragment: Fragment, api: Api): LoginViewModel {
        val viewModel = ViewModelProviders.of(fragment).get(LoginViewModel::class.java)
        viewModel.api = api
        return viewModel
    }
}