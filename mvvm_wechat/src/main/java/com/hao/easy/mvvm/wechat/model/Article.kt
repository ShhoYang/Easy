package com.hao.easy.mvvm.wechat.model

import com.hao.easy.mvvm.base.adapter.BaseItem

data class Article(var title: String,
                   var author: String,
                   var niceDate: String,
                   var link: String,
                   var projectLink: String,
                   var desc: String,
                   var envelopePic: String,
                   var collect: Boolean,
                   var originId: Int) : BaseItem()