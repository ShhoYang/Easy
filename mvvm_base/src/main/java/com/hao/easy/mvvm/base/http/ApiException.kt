package com.hao.easy.mvvm.base.http

/**
 * @author Yang Shihao
 * @date 2018/11/25
 */
class ApiException : Exception {

    constructor(msg: String) : super(msg)
}