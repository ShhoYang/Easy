package com.hao.easy.mvvm.user.ui.activity

import android.os.Handler
import android.view.WindowManager
import com.hao.easy.mvvm.base.ui.BaseActivity
import com.hao.easy.mvvm.user.R
import okhttp3.Cookie
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class WelcomeActivity : BaseActivity() {

    @Inject
    lateinit var cookies: List<Cookie>

    override fun showToolbar() = false

    override fun getLayoutId(): Int {
        return R.layout.activity_welcome
    }

    override fun initInject() {

    }

    override fun initData() {

        Handler().postDelayed({
            startActivity<LoginActivity>()
            finish()
        }, 2000)

//        var name: String? = null
//        var token: String? = null
//        cookies.forEach {
//            if (it.name() == "loginUserName") {
//                name = it.value()
//            } else if (it.name() == "token_pass") {
//                token = it.value()
//            }
//        }
//        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(token)) {
//            Handler().postDelayed({
//                startActivity<LoginActivity>()
//                finish()
//            }, 2000)
//        } else {
//            Handler().postDelayed({
//                startActivity<MainActivity>()
//                finish()
//            }, 2000)
//        }
    }

    override fun finish() {
        window.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
        super.finish()
    }
}
