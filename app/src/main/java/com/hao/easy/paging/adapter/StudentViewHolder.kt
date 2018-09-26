package com.hao.easy.paging.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.hao.easy.R
import com.hao.easy.paging.db.Student

/**
 * @author Yang Shihao
 * @date 2018/9/26
 */
class StudentViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_paging, parent, false)) {

    private val tvName = itemView.findViewById<TextView>(R.id.tv_name)
    private var student: Student? = null

    fun bindTo(student: Student?) {
        this.student = student
        tvName.text = student?.name
    }

}