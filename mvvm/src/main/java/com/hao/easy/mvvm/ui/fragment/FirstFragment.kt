package com.hao.easy.mvvm.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class FirstFragment : BaseFragment() {

    lateinit var mainAdapter: Adapter

    override fun getLayoutId() = R.layout.fragment_first

    var i = 0

    override fun initView() {
        var data = ArrayList<String>()
        (i..100).forEach { data.add(it.toString()) }
        mainAdapter = Adapter(data)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = mainAdapter
        }

        refreshLayout.setOnRefreshListener {
            refreshLayout.isRefreshing = false
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            mainAdapter.addData((--i).toString())
            recyclerView.smoothScrollToPosition(0)
        }

    }

    inner class Adapter(val data: ArrayList<String>) : RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int) = ViewHolder(TextView(p0.context))

        override fun getItemCount() = data.size

        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
            p0.textView.text = data[p1]
        }

        fun addData(item: String) {
            data.add(0, item)
            notifyItemInserted(0)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView as TextView
    }
}