package com.hao.easy.mvvm.wechat.di

import android.app.Activity
import android.support.v4.app.Fragment
import com.hao.easy.mvvm.wechat.WechatApp

fun Activity.inject(){
    WechatApp.instance.activityInjector().inject(this)
}

fun Fragment.inject(){
    WechatApp.instance.supportFragmentInjector().inject(this)
}
