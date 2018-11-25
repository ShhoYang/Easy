package com.hao.easy.mvvm.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.view.EmptyView
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }
}
