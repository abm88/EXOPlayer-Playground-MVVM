package net.playgorund.exoplayerplayground.data.repository

import androidx.lifecycle.LiveData
import net.playgorund.exoplayerplayground.data.model.ApiVideo

interface VideoRepository {

    fun getVideos() : LiveData<List<ApiVideo>>
    fun getProgress (): LiveData<Boolean>
    fun nextVideo()
}