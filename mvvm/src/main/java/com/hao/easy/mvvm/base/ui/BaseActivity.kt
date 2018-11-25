package com.hao.easy.mvvm.base.ui

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.common.App
import com.hao.easy.mvvm.inject.component.ActivityComponent
import com.hao.easy.mvvm.inject.component.DaggerConfigPersistentComponent
import com.hao.easy.mvvm.inject.module.ActivityModule
import com.hao.easy.mvvm.view.ToolbarLayout
import kotlinx.android.synthetic.main.activity_base.*

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
abstract class BaseActivity : AppCompatActivity() {

    private lateinit var activityComponent: ActivityComponent

    private var toolbar: ToolbarLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        //BackgroundLibrary.inject(this)
        super.onCreate(savedInstanceState)
        when {
            getLayoutId() == 0 -> setContentView()

            !showToolbar() -> setContentView(getLayoutId())

            else -> {
                setContentView(R.layout.activity_base)
                View.inflate(this, getLayoutId(), activityRootView)
            }
        }
        toolbar = findViewById(R.id.baseToolbar)
        toolbar?.apply {
            setBackClickListener {
                onBackPressed()
            }
        }
        onInit()
        initInject()
        initView()
        initData()
    }

    open fun onInit() {
        val configPersistentComponent = DaggerConfigPersistentComponent.builder()
                .appComponent(App.instance.appComponent)
        activityComponent = configPersistentComponent.build().activityComponent(ActivityModule(this))
    }


    fun activityComponent() = activityComponent!!

    open fun showToolbar() = true

    @LayoutRes
    abstract fun getLayoutId(): Int

    open fun setContentView() {
    }

    open fun initInject() {
    }

    open fun initView() {
    }

    open fun initData() {
    }

    override fun setTitle(title: CharSequence?) {
        toolbar?.title = title
    }
}