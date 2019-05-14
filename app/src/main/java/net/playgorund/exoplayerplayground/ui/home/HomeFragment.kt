package net.playgorund.exoplayerplayground.ui.home

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.home_fragment.*

import net.playgorund.exoplayerplayground.R
import net.playgorund.exoplayerplayground.data.model.ApiVideo
import net.playgorund.exoplayerplayground.extension.observeLiveData
import net.playgorund.exoplayerplayground.ui.home.view.MainRecyclerAdapter
import net.playgorund.exoplayerplayground.ui.home.view.MainViewHolder
import net.playgorund.exoplayerplayground.ui.player.PlayerFragment
import javax.inject.Inject

class HomeFragment : Fragment() , MainViewHolder.MainItemListener {

    companion object {
        fun newInstance() = HomeFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewmodel : ViewModel
    private val compositeDisposable = CompositeDisposable()
    private lateinit var adapter: MainRecyclerAdapter

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
    }




    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)

        super.onAttach(context)

        viewModel = ViewModelProviders.of(this , viewModelFactory ).get(HomeViewModel::class.java)


        onserveViewModel()
    }

    override fun onDetach() {
        super.onDetach()
        compositeDisposable.clear()
    }


    override fun onItemClicked(item: ApiVideo) {

        findNavController().navigate(R.id.action_homeFragment_to_playerFragment, Bundle().run {
            this.putParcelable(PlayerFragment.EXTRA_ITEM ,  item)
            this
        } )
    }



    private fun initUI() {
        adapter = MainRecyclerAdapter(this)
        rvMain.layoutManager = LinearLayoutManager(activity as Activity)
        rvMain.adapter = adapter

        viewModel.nextVideos()
    }


    private fun onserveViewModel() {
        observeLiveData(viewModel.getVideos()) {
            adapter.setData(it!!)
        }

        observeLiveData(viewModel.getProgress()) { aBoolean ->
            if (aBoolean){
                mainProgress.visibility = View.VISIBLE
            }else{
                mainProgress.visibility = View.INVISIBLE

            }
        }
    }

}
