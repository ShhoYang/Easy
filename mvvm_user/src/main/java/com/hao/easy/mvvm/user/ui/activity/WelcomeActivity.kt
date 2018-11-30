package com.hao.easy.mvvm.user.ui.activity

import android.os.Handler
import android.text.TextUtils
import android.view.WindowManager
import com.alibaba.android.arouter.launcher.ARouter
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.ui.BaseActivity
import com.hao.easy.mvvm.user.R
import com.hao.easy.mvvm.user.inject.component.DaggerActivityComponent
import okhttp3.Cookie
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class WelcomeActivity : BaseActivity() {

    @Inject
    lateinit var cookies: List<Cookie>

    companion object {
        private val DURATION = 1500L
    }

    override fun showToolbar() = false

    override fun getLayoutId(): Int {
        return R.layout.activity_welcome
    }

    override fun initInject() {
        DaggerActivityComponent.builder()
                .appComponent(App.instance.appComponent)
                .build().inject(this)
    }

    override fun initData() {

        var name: String? = null
        var token: String? = null
        cookies.forEach {
            if (it.name() == "loginUserName") {
                name = it.value()
            } else if (it.name() == "token_pass") {
                token = it.value()
            }
        }
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(token)) {
            Handler().postDelayed({
                startActivity<LoginActivity>()
                finish()
            }, DURATION)
        } else {
            Handler().postDelayed({
                ARouter.getInstance().build("/app/MainActivity").navigation()
                finish()
            }, DURATION)
        }
    }

    override fun finish() {
        window.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
        super.finish()
    }
}
