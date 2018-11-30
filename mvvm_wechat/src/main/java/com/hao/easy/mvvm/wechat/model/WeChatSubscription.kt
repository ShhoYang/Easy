package com.hao.easy.mvvm.wechat.model

import com.hao.easy.mvvm.base.adapter.BaseItem

data class Author(var courseId: Int,
                  var id: Int,
                  var name: String,
                  var order: Int,
                  var parentChapterId: Int,
                  var userControlSetTop: Boolean,
                  var visible: Int)

data class Article(var title: String,
                   var author: String,
                   var niceDate: String,
                   var link: String,
                   var collect: Boolean) : BaseItem()