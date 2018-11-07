package com.hao.easy.cmakeso

object NativeFun {

    init {
        System.loadLibrary("native_hello")
    }

    external fun outputJsonCode(name: String, age: String, sex: String, type: String): String

    external fun parseJsonCode(json: String): String
}