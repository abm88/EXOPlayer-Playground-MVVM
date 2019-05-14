package net.playgorund.exoplayerplayground.data.repository

import androidx.lifecycle.LiveData
import net.playgorund.exoplayerplayground.data.model.ApiVideo
import net.playgorund.exoplayerplayground.data.source.VideoDataSource.VideoDataSource
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(val dataSource : VideoDataSource): VideoRepository {

    init {

    }

    override fun getVideos(): LiveData<List<ApiVideo>> {
        return dataSource.videos
    }

    override fun getProgress(): LiveData<Boolean> {
        return dataSource.progress
    }

    override fun nextVideo() {
        dataSource.getVideo()
    }


}