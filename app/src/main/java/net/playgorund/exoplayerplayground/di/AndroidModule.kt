package net.playgorund.exoplayerplayground.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule {

    @Provides
    @Singleton
    fun provideContext(application : Application) = application.applicationContext

}