package com.hao.easy.paging.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.hao.easy.paging.db.Student

/**
 * @author Yang Shihao
 * @date 2018/9/26
 */
class StudentAdapter : PagedListAdapter<Student, StudentViewHolder>(diffCallback) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Student>() {
            override fun areItemsTheSame(p0: Student, p1: Student): Boolean =
                    p0.id == p1.id


            override fun areContentsTheSame(p0: Student, p1: Student): Boolean =
                    p0 == p1
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): StudentViewHolder = StudentViewHolder(p0)

    override fun onBindViewHolder(p0: StudentViewHolder, p1: Int) {
        p0.bindTo(getItem(p1))
    }
}