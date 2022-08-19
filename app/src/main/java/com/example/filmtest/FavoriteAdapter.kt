package com.example.filmtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.databinding.ActivityDetailedBinding
import com.example.filmtest.databinding.ActivityMainBinding
import com.example.filmtest.databinding.CardMovieBinding
import com.example.filmtest.databinding.FavoriteActivityBinding


class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.HolderMovieFavorite>{

    private val context: Context
    private lateinit var filmList: ArrayList<FilmModel>



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderMovieFavorite {
        binding = CardMovieBinding.inflate(LayoutInflater.from(context), parent, false)
        return HolderMovieFavorite(binding.root)
    }

    override fun onBindViewHolder(holder: HolderMovieFavorite, position: Int) {
        val model = filmList[position]
        loadFilmDetailed(model, holder)
    }

    private fun loadFilmDetailed(model: FilmModel, holder: FavoriteAdapter.HolderMovieFavorite) {
        val id = model.id

    }

    override fun getItemCount(): Int {
        return filmList.size
    }





    private lateinit var binding: CardMovieBinding



    constructor(context: Any, movieArrayList: ArrayList<FilmModel>) {
        this.context = context as Context
        this.filmList = filmList
    }

    inner class HolderMovieFavorite(itemView: View) : RecyclerView.ViewHolder(itemView){
        var detailedActivityFav = binding.detailedActivityFav
        var nameFav = binding.nameFav
        var removeFavorite = binding.removeFavorite

    }

}
