package net.playgorund.exoplayerplayground.data.source.VideoDataSource

import androidx.lifecycle.LiveData
import net.playgorund.exoplayerplayground.data.model.ApiVideo

interface VideoDataSource {

    val videos : LiveData<List<ApiVideo>>
    val progress : LiveData<Boolean>

    fun getVideo()

}