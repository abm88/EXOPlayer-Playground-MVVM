package net.playgorund.exoplayerplayground.di

import androidx.annotation.NonNull
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.twistedequations.rx2.AndroidRxSchedulers
import net.playgorund.exoplayerplayground.data.source.service.CloudinaryApi
import dagger.Module
import dagger.Provides
import net.playgorund.exoplayerplayground.AppConstant
import net.playgorund.exoplayerplayground.data.repository.VideoRepository
import net.playgorund.exoplayerplayground.data.repository.VideoRepositoryImpl
import net.playgorund.exoplayerplayground.data.source.VideoDataSource.VideoDataSource
import net.playgorund.exoplayerplayground.data.source.VideoDataSource.VideoDataSourceImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
//            .addInterceptor(RequestInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }


    @Provides
    @Singleton
    fun proviudeRetrofit(@NonNull okHttpClient : OkHttpClient) : Retrofit {

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(AppConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideVideoService(@NonNull retrofit: Retrofit) : CloudinaryApi {
        return retrofit.create(CloudinaryApi::class.java)
    }


    @Provides
    @Singleton
    fun provideVideoDataSource(@NonNull service : CloudinaryApi,
                               @NonNull rxSchedulers: AndroidRxSchedulers
    ) : VideoDataSource {
        return VideoDataSourceImpl(service , rxSchedulers)
    }

    @Provides
    @Singleton
    fun provideRepository(@NonNull dataSource : VideoDataSource  ) : VideoRepository {

        return VideoRepositoryImpl(dataSource)
    }



}