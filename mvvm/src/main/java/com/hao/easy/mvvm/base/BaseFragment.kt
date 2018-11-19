package com.hao.easy.mvvm.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.gson.GsonRequestBodyConverter

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        var gsonRequestBodyConverter = GsonConverterFactory<Any>()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initView()

}