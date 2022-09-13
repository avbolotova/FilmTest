package com.example.filmtest.main

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.R
import com.example.filmtest.main.FilmsAdapter.FilmsViewHolder

class FilmsAdapter(
    private var films: MutableList<Films>,
    private val onViewFilmsClick: (Films) -> Unit,
    private val onSetFavoriteClick: (Films) -> Unit,
) : RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        val viewHolder = FilmsViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        val film = films[position]
        holder.bind(film, onViewFilmsClick, onSetFavoriteClick)
    }

    override fun getItemCount(): Int = films.size

    fun refreshFilms(films: MutableList<Films>) {
        this.films = films
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Films = films[position]


    class FilmsViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            film: Films,
            onViewFilmsClick: (Films) -> Unit,
            onSetFavoriteClick: (Films) -> Unit,
        ) {

            val image = itemView.findViewById<ImageView>(R.id.imageView)
            val nameFilm = itemView.findViewById<TextView>(R.id.textView)
            val buttonDet = itemView.findViewById<Button>(R.id.buttonDes)
            val buttonSetFavorite = itemView.findViewById<ImageView>(R.id.favoriteFilms)

            val favoriteImageResId = getFavoriteImageResId(film.isFavorite)

            image.setImageResource(film.imageResId)

            nameFilm.setText(film.title)

            buttonDet.apply {
                text = film.title
                setOnClickListener { onViewFilmsClick(film) }
            }
            buttonSetFavorite.apply {
                setImageResource(favoriteImageResId)
                setOnClickListener { onSetFavoriteClick(film) }
            }
        }


        private fun getFavoriteImageResId(isFavorite: Boolean): Int {
            return if (isFavorite) R.drawable.ic_favorite_fool_roz
            else R.drawable.ic_favorite_roz
        }
    }
}




