package com.example.filmtest.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.R
import com.example.filmtest.main.Films


class FavoriteAdapter(private var films: List<Films>) :
    RecyclerView.Adapter<FavoriteAdapter.FavoriteFilmsViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteFilmsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_movie, parent, false)
        val viewHolder = FavoriteFilmsViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: FavoriteFilmsViewHolder, position: Int) {
        val film = films[position]
        holder.bind(film)
    }

    override fun getItemCount(): Int = films.size

    fun refreshFilms(films: List<Films>) {
        this.films = films
        notifyItemChanged(1)

    }

    fun getItem(position: Int) : Films = films[position]


    class FavoriteFilmsViewHolder (item: View) : RecyclerView.ViewHolder(item){
        fun bind(film: Films) {
            val image = itemView.findViewById<ImageView>(R.id.FavActImage)
            val titleName = itemView.findViewById<TextView>(R.id.FavName)

            image.setImageResource(film.imageResId)
            titleName.apply {
                text = film.title
            }
        }

    }

}









