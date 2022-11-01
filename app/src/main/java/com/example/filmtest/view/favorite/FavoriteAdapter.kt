package com.example.filmtest.view.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmtest.MAIN
import com.example.filmtest.R
import com.example.filmtest.model.Item
import com.example.filmtest.view.main.MainAdapter
import com.example.filmtest.view.main.MainFragment

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private var listMovies = emptyList<Item>()

    class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.textView).text = listMovies[position].title
        holder.itemView.findViewById<TextView>(R.id.rtText).text = listMovies[position].imDbRating
        holder.itemView.findViewById<TextView>(R.id.yearText).text = listMovies[position].year

        Glide.with(MAIN)
            .load(listMovies[position].image)
            .placeholder(R.drawable.item_divider)
            .into(holder.itemView.findViewById(R.id.imageView))
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }
    fun setList(list: List<Item>){
        listMovies = list
        notifyItemChanged(1)

    }

    fun getItem(position: Int) : Item = listMovies[position]

    override fun onViewAttachedToWindow(holder: FavoriteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            FavoriteFragment.clickFilmsFavorite(listMovies[holder.adapterPosition])
        }
    }

}