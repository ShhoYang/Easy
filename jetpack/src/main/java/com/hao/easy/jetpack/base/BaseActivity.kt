package com.hao.easy.jetpack.base

import android.app.Activity
import android.app.ProgressDialog
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.hao.easy.jetpack.utils.T

/**
 * @author Yang Shihao
 * @date 2018/11/16
 */
abstract class BaseActivity : AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initInject()
        initView()
        initData()
    }

    override fun onDestroy() {
        dismissDialog()
        super.onDestroy()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initInject()

    abstract fun initView()

    abstract fun initData()

    fun showDialog() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this);
        }

        progressDialog?.apply {
            setMessage("正在加载")
            if (!isShowing) {
                show()
            }
        }
    }

    fun showDialog(msg: String) {

    }

    fun dismissDialog() {
        progressDialog?.apply {
            if (isShowing) {
                dismiss()
            }
        }
        progressDialog = null
    }

    fun startActivity(cls: Class<in Activity>) {

    }

    fun toast(msg: String) {
        T.toast(this, msg)
    }
}