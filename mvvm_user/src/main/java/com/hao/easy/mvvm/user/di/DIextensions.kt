package com.hao.easy.mvvm.user.di

import android.app.Activity
import android.support.v4.app.Fragment
import com.hao.easy.mvvm.user.UserApp

/**
 * @author Yang Shihao
 * @date 2018/12/9
 */

fun Activity.inject(){
    UserApp.instance.activityInjector().inject(this)
}

fun Fragment.inject(){
    UserApp.instance.supportFragmentInjector().inject(this)
}
