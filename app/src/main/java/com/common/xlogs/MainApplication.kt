package com.common.xlogs

import com.common.xlogs.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 *@author: zhanwei
 *@Date: 2021/09/25
 *@Description:
 */
class MainApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }



    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}
