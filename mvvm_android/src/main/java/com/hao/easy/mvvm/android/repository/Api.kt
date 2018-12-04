package com.hao.easy.mvvm.android.repository

import com.hao.easy.mvvm.base.App

/**
 * @author Yang Shihao
 * @date 2018/11/19
 */

object Api : Service by App.instance.appComponent.retrofit().create(Service::class.java)

interface Service {
}