package com.hao.plugin

import org.gradle.api.Plugin


class HaoPlugin implements Plugin<Object> {

    @Override
    void apply(Object o) {
        println("----------  this is a buildSrc plugin  ----------")
    }
}