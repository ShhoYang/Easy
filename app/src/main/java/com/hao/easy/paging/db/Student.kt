package com.hao.easy.paging.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author Yang Shihao
 * @date 2018/9/26
 */
@Entity
data class Student(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)