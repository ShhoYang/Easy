package com.hao.easy.mvvm

/**
 * @author Yang Shihao
 * @date 2018/11/25
 */
data class User(var id: Int,
                var username: String,
                var token: String,
                var icon: String,
                var email: String,
                var collectIds: ArrayList<Int>)
