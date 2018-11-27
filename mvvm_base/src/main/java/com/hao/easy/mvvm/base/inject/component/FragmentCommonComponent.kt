package com.hao.easy.mvvm.inject.component

import com.hao.easy.mvvm.inject.PreFragment
import com.hao.easy.mvvm.inject.module.FragmentCommonModule
import dagger.Subcomponent

/**
 * @author Yang Shihao
 * @date 2018/10/23
 */
@PreFragment
@Subcomponent(modules = [FragmentCommonModule::class])
interface FragmentCommonComponent {

}