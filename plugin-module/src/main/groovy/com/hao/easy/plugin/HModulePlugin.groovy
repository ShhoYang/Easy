package com.hao.easy.plugin

import org.gradle.api.Plugin


class HModulePlugin implements Plugin<Object> {

    @Override
    void apply(Object o) {
        println("----------  this is a groovy plugin  ----------")
    }
}