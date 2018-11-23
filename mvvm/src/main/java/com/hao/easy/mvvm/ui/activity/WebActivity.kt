package com.hao.easy.mvvm.ui.activity

import android.annotation.SuppressLint
import android.content.Context
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_web.*
import org.jetbrains.anko.startActivity

class WebActivity : BaseActivity() {

    companion object {
        private const val TITLE = "TITLE"
        private const val URL = "URL"
        fun start(context: Context, title: String, url: String) {
            context.startActivity<WebActivity>(Pair(TITLE, title), Pair(URL, url))
        }
    }

    override fun getLayoutId() = R.layout.activity_web

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView() {
        super.initView()
        title = "详情"
        webView.loadUrl(intent.getStringExtra(URL))
    }
}

