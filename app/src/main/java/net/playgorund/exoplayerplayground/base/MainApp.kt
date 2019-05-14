package net.playgorund.exoplayerplayground.base

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import net.playgorund.exoplayerplayground.di.DaggerAppComponent

class MainApp :DaggerApplication() {

    private val appComponent = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {


        return appComponent

    }
}