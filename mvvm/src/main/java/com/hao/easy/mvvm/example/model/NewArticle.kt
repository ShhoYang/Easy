package com.hao.easy.mvvm.example.model

import com.hao.easy.mvvm.base.adapter.BaseItem

/**
 * @author Yang Shihao
 * @date 2018/11/21
 */
data class NewArticle(var title: String,
                      var author: String,
                      var niceDate: String,
                      var link: String,
                      var projectLink: String,
                      var desc: String,
                      var envelopePic: String) : BaseItem()