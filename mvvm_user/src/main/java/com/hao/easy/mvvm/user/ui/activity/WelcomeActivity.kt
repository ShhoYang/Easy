package com.hao.easy.mvvm.user.ui.activity

import android.os.Handler
import android.view.WindowManager
import com.alibaba.android.arouter.launcher.ARouter
import com.hao.easy.mvvm.base.ui.BaseActivity
import com.hao.easy.mvvm.user.R

class WelcomeActivity : BaseActivity() {

    companion object {
        private val DURATION = 1500L
    }

    override fun showToolbar() = false

    override fun getLayoutId(): Int {
        return R.layout.activity_welcome
    }

    override fun initData() {

        Handler().postDelayed({
            ARouter.getInstance().build("/app/MainActivity").navigation()
            finish()
        }, DURATION)

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
//            }, DURATION)
//        } else {
//
//        }
    }

    override fun finish() {
        window.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
        super.finish()
    }
}
