package net.playgorund.exoplayerplayground.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.playgorund.exoplayerplayground.ui.home.HomeFragment
import net.playgorund.exoplayerplayground.ui.player.PlayerFragment


@Module
abstract class MainActivityFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributePlayerFragment(): PlayerFragment
}