package com.hao.easy.cmake

/**
 * @author Yang Shihao
 */
object NativeFun {

    init {
        System.loadLibrary("native_hello")
    }

    external fun stringFromJNI(): String
}
