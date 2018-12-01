package com.hao.easy.mvvm.inject.component

import com.hao.easy.mvvm.inject.PreActivity
import com.hao.easy.mvvm.inject.module.ActivityCommonModule
import dagger.Subcomponent

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreActivity
@Subcomponent(modules = [ActivityCommonModule::class])
interface ActivityCommonComponent {

}