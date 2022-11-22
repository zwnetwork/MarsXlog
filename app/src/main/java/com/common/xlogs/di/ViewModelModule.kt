package com.common.xlogs.di

import androidx.lifecycle.ViewModelProvider
import com.common.library.di.BMViewModelFactory
import com.common.library.di.BaseModule
import dagger.Binds
import dagger.Module

/**
 *
 * @description
 * @author : create by zhanwei
 * @time 2022/8/8
 */
@Module
abstract class ViewModelModule : BaseModule() {

    @Binds
    abstract fun bindViewModelFactory(factory: BMViewModelFactory): ViewModelProvider.Factory
}
