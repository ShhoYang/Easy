package com.hao.easy.mvvm.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.extensions.gone
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebView
import org.jetbrains.anko.dip

class ProgressWebView : WebView {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    private fun init() {
        overScrollMode = View.OVER_SCROLL_NEVER
        settings.javaScriptEnabled = true
        val progressBar = ProgressBar(context)
        progressBar?.apply {
            max = 100
            val params = LayoutParams(LayoutParams.MATCH_PARENT, dip(2))
            layoutParams = params
            progressDrawable = ContextCompat.getDrawable(context, R.drawable.progress_bar)
            this@ProgressWebView.addView(this, params)
            bringToFront()
            webChromeClient = WebClient(this)
        }
    }

    class WebClient(val progressBar: ProgressBar) : WebChromeClient() {

        var isAnimStart = false

        override fun onProgressChanged(p0: WebView?, p1: Int) {
            super.onProgressChanged(p0, p1)
            if (p1 >= 100 && !isAnimStart) {
                isAnimStart = true
                startDismissAnim(p1)

            } else {
                startProgressAnim(progressBar.progress, p1)
            }
        }

        private fun startProgressAnim(start: Int, end: Int) {
            val animator = ObjectAnimator.ofInt(progressBar, "progress", start, end)
            animator.duration = 300
            animator.start()
        }

        private fun startDismissAnim(progress: Int) {
            val animator = ObjectAnimator.ofFloat(progressBar, "alpha", 1.0F, .0F)
            animator.duration = 300
            animator.addUpdateListener {
                var fraction = it.animatedFraction
                var offset = 100 - progress
                setProgress((progress + offset * fraction).toInt())
            }
            animator.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    setProgress(0)
                    progressBar?.gone()
                    isAnimStart = false
                }
            })
            animator.start()
        }

        private fun setProgress(progress: Int) {
            progressBar?.progress = progress
        }
    }
}
