package net.playgorund.exoplayerplayground.ui.player

import androidx.lifecycle.ViewModel;
import net.playgorund.exoplayerplayground.data.model.ApiVideo
import net.playgorund.exoplayerplayground.ui.player.MediaPlayer.MediaPlayer
import net.playgorund.exoplayerplayground.ui.player.MediaPlayer.MediaPlayerImpl
import javax.inject.Inject

class PlayerViewModel @Inject constructor(): ViewModel() {
    private  val mediaPlayer = MediaPlayerImpl()



    fun getMediaPlayer() = mediaPlayer

    fun play(url : String ) = mediaPlayer.play(url)


    fun release() = mediaPlayer.releasePlayer()

    fun createVideoUrl(video: ApiVideo) =
        "https://res.cloudinary.com/demo/video/${video.type}/v${video.version}/${video.publicId}.${video.format}"



}
