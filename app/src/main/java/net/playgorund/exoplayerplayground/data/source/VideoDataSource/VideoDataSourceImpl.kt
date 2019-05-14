package net.playgorund.exoplayerplayground.data.source.VideoDataSource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.playgorund.exoplayerplayground.data.source.service.CloudinaryApi
import com.twistedequations.rx2.AndroidRxSchedulers
import net.playgorund.exoplayerplayground.data.model.ApiVideo
import javax.inject.Inject

class VideoDataSourceImpl @Inject constructor(val service : CloudinaryApi ,
                                              val rxSchedulers: AndroidRxSchedulers) : VideoDataSource {


    override val videos: LiveData<List<ApiVideo>>
        get() =  _videos
    override val progress: LiveData<Boolean>
        get() = _progress


    private val _videos = MutableLiveData<List<ApiVideo>>()
    private val _progress = MutableLiveData<Boolean>()
    private val _pageLiveData = MutableLiveData<Int>()


    init {
        _pageLiveData.observeForever{
            service.fetchVideos()
                .observeOn(rxSchedulers.mainThread()).subscribeOn(rxSchedulers.io())
                .subscribe ({

                    _videos.postValue(it?.resources?.subList(0 , 30 ))

                } , {
                    it.printStackTrace()
                })
        }
    }

    override fun getVideo() {
        _pageLiveData.postValue(1)
    }
}