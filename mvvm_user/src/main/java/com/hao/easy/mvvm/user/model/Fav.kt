package com.hao.easy.mvvm.user.model

import com.hao.easy.mvvm.base.adapter.BaseItem

/**
 * @author Yang Shihao
 * @date 2018/12/3
 */
data class Fav(var title: String,
               var author: String,
               var niceDate: String,
               var link: String,
               var originId: Int) : BaseItem()
