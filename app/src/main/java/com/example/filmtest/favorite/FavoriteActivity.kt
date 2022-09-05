package com.example.filmtest.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.R
import com.example.filmtest.main.Films
import com.example.filmtest.main.FilmsAdapter
import com.example.filmtest.repo.FilmsRepo

class FavoriteActivity: AppCompatActivity() {

    private lateinit var adapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        initRecyclerView()
    }


    private fun initRecyclerView() {
        adapter = FavoriteAdapter(films = FilmsRepo.getFavoriteFilms())
        val recyclerFavoriteMovies = findViewById<RecyclerView>(R.id.recyclerViewFav)
        recyclerFavoriteMovies.adapter = adapter

        val itemTouchHelper = ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean = false

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val film = adapter.getItem(viewHolder.adapterPosition)
                    FilmsRepo.deleteFromFavorites(film)
                    adapter.refreshFilms(FilmsRepo.getFavoriteFilms())
                }
            }
        )
        itemTouchHelper.attachToRecyclerView(recyclerFavoriteMovies)
    }
}
