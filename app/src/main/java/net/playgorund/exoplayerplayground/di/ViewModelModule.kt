package net.playgorund.exoplayerplayground.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import net.playgorund.exoplayerplayground.factory.AppViewModelFactory
import net.playgorund.exoplayerplayground.ui.home.HomeViewModel
import net.playgorund.exoplayerplayground.ui.player.PlayerViewModel


@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun bindHomeFragmentViewModel(homeViewModel: HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PlayerViewModel::class)
    internal abstract fun bindPlayerFragmentViewModel(homeViewModel: PlayerViewModel) : ViewModel


    @Binds
    internal abstract fun bindViewModelFactory(factory : AppViewModelFactory) : ViewModelProvider.Factory


}