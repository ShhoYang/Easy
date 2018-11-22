package com.hao.easy.paging

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.util.Log
import com.hao.easy.R
import com.hao.easy.base.BaseActivity
import com.hao.easy.paging.adapter.StudentAdapter
import kotlinx.android.synthetic.main.activity_paging.*

class PagingActivity : BaseActivity() {

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T = StudentViewModel(application) as T
        }).get(StudentViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_paging
    }

    override fun initView() {
    }

    override fun initData() {
        val adapter = StudentAdapter()
        recyclerView.adapter = adapter
        viewModel.allStudents.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    var i: Int = 0

//    override fun onBackPressed() {
//        //super.onBackPressed()
//        ioThread {
//            viewModel.insertStudent(i++.toString())
//        }
//
//    }
}
