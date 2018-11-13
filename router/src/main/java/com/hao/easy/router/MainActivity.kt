package com.hao.easy.router

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hao.easy.router.annotation.Route
import com.hao.easy.router.core.Router
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = "/main/MainActivity")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Router.init(application)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener {
            Router.getInstance().build("/module1/Module1Activity").navigation()
        }
        btn2.setOnClickListener {
            Router.getInstance().build("/module2/Module2Activity").navigation()
        }
    }
}
