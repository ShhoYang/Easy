package com.hao.easy.mvvm.first.model

import com.hao.easy.mvvm.base.adapter.BaseItem

data class Author(var courseId: Int,
                  var id: Int,
                  var name: String,
                  var order: Int,
                  var parentChapterId: Int,
                  var userControlSetTop: Boolean,
                  var visible: Int)

class ArticleList(var curPage: Int,
                  var pageCount: Int,
                  var size: Int,
                  var total: Int,
                  var datas: ArrayList<Article>)

data class Article(var title: String,
                   var author: String,
                   var niceDate: String,
                   var link: String) : BaseItem()