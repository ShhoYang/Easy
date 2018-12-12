package com.hao.easy.mvvm.wechat.di

import android.app.Activity
import android.support.v4.app.Fragment
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.wechat.di.component.ActivityComponent
import com.hao.easy.mvvm.wechat.di.component.DaggerActivityComponent
import com.hao.easy.mvvm.wechat.di.component.DaggerFragmentComponent
import com.hao.easy.mvvm.wechat.di.component.FragmentComponent

fun Activity.component(): ActivityComponent =
        DaggerActivityComponent.builder()
                .appComponent(App.instance.appComponent)
                .build()

fun Fragment.component(): FragmentComponent =
        DaggerFragmentComponent.builder()
                .appComponent(App.instance.appComponent)
                .build()
