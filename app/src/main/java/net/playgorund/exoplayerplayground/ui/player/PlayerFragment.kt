package net.playgorund.exoplayerplayground.ui.player

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.player_fragment.*

import net.playgorund.exoplayerplayground.R
import net.playgorund.exoplayerplayground.data.model.ApiVideo
import net.playgorund.exoplayerplayground.ui.home.HomeViewModel
import javax.inject.Inject

class PlayerFragment : Fragment() {

    companion object {
        const val EXTRA_ITEM = "EXTRA_URL"
        fun newInstance(item  :ApiVideo ) = PlayerFragment().let { fragment ->
            Bundle().let {
                it.putParcelable(EXTRA_ITEM , item)
                fragment.arguments = it
            }
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var exoPlayer: ExoPlayer
    private lateinit var viewModel: PlayerViewModel
    private lateinit var plaerView : PlayerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.player_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUi()

    }


    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)

        super.onAttach(context)
        viewModel = ViewModelProviders.of(this ,viewModelFactory )
            .get(PlayerViewModel::class.java)

    }

    override fun onStop() {
        super.onStop()
        viewModel.release()
    }


    private fun initUi() {
        exoPlayer = viewModel.getMediaPlayer().getPlayer(activity as Activity)
        playerView.player = exoPlayer
        viewModel.play(viewModel.createVideoUrl(arguments?.getParcelable<ApiVideo>(EXTRA_ITEM)!!))
    }

}
