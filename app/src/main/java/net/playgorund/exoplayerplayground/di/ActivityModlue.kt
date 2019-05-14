package net.playgorund.exoplayerplayground.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.playgorund.exoplayerplayground.ui.home.HomeActivity


@Module
abstract class ActivityModlue {

    @ContributesAndroidInjector(modules = [MainActivityFragmentModule::class])
    internal abstract fun contributeMainActivity():HomeActivity
}