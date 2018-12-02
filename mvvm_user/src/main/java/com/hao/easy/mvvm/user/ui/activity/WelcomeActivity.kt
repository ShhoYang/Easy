package com.hao.easy.mvvm.user.ui.activity

import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.alibaba.android.arouter.launcher.ARouter
import com.hao.easy.mvvm.base.Config
import com.hao.easy.mvvm.base.ui.BaseActivity
import com.hao.easy.mvvm.user.R
import kotlin.concurrent.thread

class WelcomeActivity : BaseActivity() {

    companion object {
        private const val DURATION = 1500L
    }

    override fun showToolbar() = false

    override fun getLayoutId(): Int {
        return R.layout.activity_welcome
    }

    override fun initData() {
        thread {
            var l = System.currentTimeMillis()
            Config.instance().init()
            var delayTime = DURATION + l - System.currentTimeMillis()
            if (delayTime <= 0) {
                start()
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    start()
                }, delayTime)
            }
        }
    }

    private fun start() {
        ARouter.getInstance().build("/app/MainActivity").navigation()
        finish()
    }

    override fun finish() {

        window.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
        super.finish()
    }
}
