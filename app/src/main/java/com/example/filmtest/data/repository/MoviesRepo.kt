package com.example.filmtest.data.repository

import androidx.lifecycle.LiveData
import com.example.filmtest.model.Item

interface MoviesRepo {

    val allMovies : LiveData<List<Item>>
    suspend fun insertMovie(item:Item, onSuccess:() -> Unit)
    suspend fun deleteMovie(item:Item, onSuccess:() -> Unit)
}