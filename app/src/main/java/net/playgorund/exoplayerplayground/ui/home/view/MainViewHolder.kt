package net.playgorund.exoplayerplayground.ui.home.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_adapter.view.*
import net.playgorund.exoplayerplayground.data.model.ApiVideo

class MainViewHolder(val view : View , val listener : MainItemListener) : RecyclerView.ViewHolder(view) {

    fun bind(item : ApiVideo){
        view.mainAdapterItemTitle.text = item.publicId
        itemView.setOnClickListener {
            listener.onItemClicked(item)
        }
    }

    interface MainItemListener{
        fun onItemClicked(item : ApiVideo)
    }
}