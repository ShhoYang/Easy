package com.hao.easy.paging.db

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * @author Yang Shihao
 * @date 2018/9/26
 */
@Dao
interface StudentDao {

    @Insert
    fun insert(student: Student)

    @Insert
    fun insert(students: List<Student>)

    @Query("SELECT * FROM Student ORDER BY name COLLATE NOCASE ASC")
    fun getAllStudent(): DataSource.Factory<Int, Student>
}