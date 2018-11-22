package com.hao.easy.paging

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.hao.easy.paging.db.Student
import com.hao.easy.paging.db.StudentDb

/**
 * @author Yang Shihao
 * @date 2018/9/26
 */
class StudentViewModel(app: Application) : AndroidViewModel(app) {

    companion object {

        private const val PAGE_SIZE = 15

        private const val ENABLE_PLACEHOLDERS = false
    }

    val dao = StudentDb.get(app).studentDao()

    val allStudents = LivePagedListBuilder(DataSourceFactory(),
            PagedList.Config.Builder()
                    .setPageSize(PAGE_SIZE)
                    .setEnablePlaceholders(ENABLE_PLACEHOLDERS)
                    .setInitialLoadSizeHint(PAGE_SIZE)
                    .build()
    ).build()

    fun insertStudent(name: String) {
        dao.insert(Student(0, name))
    }
}