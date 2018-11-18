package com.hao.easy.jetpack

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author Yang Shihao
 * @date 2018/11/17
 */
private class NotNullSingleValue<T> : ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if (this.value == null) {
            this.value = value
        } else {
            throw IllegalStateException("already initialized")
        }
    }
}

fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValue()