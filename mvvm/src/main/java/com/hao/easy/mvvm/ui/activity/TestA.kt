package com.hao.easy.mvvm.ui.activity

import com.hao.easy.mvvm.base.ui.BaseActivity
import com.hao.easy.mvvm.extensions.snack
import org.jetbrains.anko.*

class TestA : BaseActivity() {

    override fun getLayoutId() = 0

    override fun setContentView() {

        verticalLayout {
            button("btn2") {
                setOnClickListener { snack("btn2") }
            }.lparams(width = matchParent) {
                verticalMargin = dip(12)
            }
        }
    }
}