package com.example.filmtest.view.shedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmtest.MAIN
import com.example.filmtest.R
import com.example.filmtest.model.Item
import com.example.filmtest.view.favorite.FavoriteAdapter
import com.example.filmtest.view.favorite.FavoriteFragment

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    private var listMovies = emptyList<Item>()

    class ScheduleViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_movie, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.FavName).text = listMovies[position].title

        Glide.with(MAIN)
            .load(listMovies[position].image)
            .placeholder(R.drawable.item_divider)
            .into(holder.itemView.findViewById(R.id.FavActImage))
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun setList(list: List<Item>) {
        listMovies = list
        notifyItemChanged(1)

    }

    fun getItem(position: Int): Item = listMovies[position]

    override fun onViewAttachedToWindow(holder: ScheduleViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            ScheduleFragment.clickFilmsShedule(listMovies[holder.adapterPosition])
        }
    }
}