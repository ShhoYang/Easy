package com.hao.easy.paging

import java.util.concurrent.Executors

/**
 * @author Yang Shihao
 * @date 2018/9/26
 */

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

fun ioThread(f: () -> Unit) {
    IO_EXECUTOR.execute(f)
}