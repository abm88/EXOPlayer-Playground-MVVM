package net.playgorund.exoplayerplayground.ui.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.playgorund.exoplayerplayground.R
import net.playgorund.exoplayerplayground.data.model.ApiVideo

class MainRecyclerAdapter(val listener : MainViewHolder.MainItemListener) : RecyclerView.Adapter<MainViewHolder>() {


    private val items : MutableList<ApiVideo> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_adapter , parent , false)
        return MainViewHolder(v , listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setData(data : List<ApiVideo>){
        items.addAll(data)
        notifyDataSetChanged()
    }

}