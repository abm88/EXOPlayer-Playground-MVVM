package net.playgorund.exoplayerplayground.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import net.playgorund.exoplayerplayground.data.model.ApiVideo
import net.playgorund.exoplayerplayground.data.repository.VideoRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: VideoRepository): ViewModel() {

    private val videos = MutableLiveData<List<ApiVideo>>()


    init {
        repository.getVideos().observeForever {
            videos.postValue(it)
        }
    }

    fun getVideos() = videos
    fun nextVideos() = repository.nextVideo()
    fun getProgress() = repository.getProgress()


}
