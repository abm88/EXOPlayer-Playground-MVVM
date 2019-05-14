package net.playgorund.exoplayerplayground.di

import androidx.annotation.NonNull
import com.twistedequations.rx2.AndroidRxSchedulers
import dagger.Module
import dagger.Provides
import net.playgorund.exoplayerplayground.data.repository.VideoRepository
import net.playgorund.exoplayerplayground.data.repository.VideoRepositoryImpl
import net.playgorund.exoplayerplayground.data.source.VideoDataSource.VideoDataSource
import net.playgorund.exoplayerplayground.data.source.VideoDataSource.VideoDataSourceImpl
import net.playgorund.exoplayerplayground.data.source.service.CloudinaryApi
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class DataModule {


}