package com.hao.easy.cmakeso

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val json = NativeFun.outputJsonCode("姓名", "25", "男", "so")
        textView.text = json

        val parse = NativeFun.parseJsonCode(json)
        textView.apply {
            append("\n")
            append(parse)
        }
    }
}
