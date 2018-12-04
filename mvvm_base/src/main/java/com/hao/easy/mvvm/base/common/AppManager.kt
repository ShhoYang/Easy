package com.hao.easy.mvvm.base.common

import android.app.Activity

class AppManager private constructor() {

    private val list = ArrayList<Activity>()

    companion object {
        private var instance: AppManager? = null

        @Synchronized
        public fun instance(): AppManager {
            if (instance == null) {
                instance = AppManager()
            }
            return instance!!
        }
    }

    fun pushActivity(activity: Activity) {
        list.add(activity)
    }

    fun popActivity(activity: Activity) {
        process { it == activity }
    }

    fun finishActivity(cls: Class<Activity>) {
        process { it.javaClass == cls }
    }

    fun exit() {
        process { true }
        android.os.Process.killProcess(android.os.Process.myPid())
        System.exit(0)
    }

    private fun process(b: (Activity) -> Boolean) {
        if (list.isEmpty()) {
            return
        }
        var iterator = list.iterator()
        while (iterator.hasNext()) {
            var next = iterator.next()
            if (b(next)) {
                if (!next.isFinishing) {
                    next.finish()
                }
            }
        }
    }
}