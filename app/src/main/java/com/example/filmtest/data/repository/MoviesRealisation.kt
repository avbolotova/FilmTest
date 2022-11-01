package com.example.filmtest.data.repository

import androidx.lifecycle.LiveData
import com.example.filmtest.data.room.MoviesDao

import com.example.filmtest.model.Item

class MoviesRealisation(private val MoviesDao: MoviesDao) : MoviesRepo{

    override val allMovies: LiveData<List<Item>>
        get() = MoviesDao.getAllMovies()

    override suspend fun insertMovie(item: Item, onSuccess: () -> Unit) {
        MoviesDao.insert(item)
        onSuccess()
    }

    override suspend fun deleteMovie(item: Item, onSuccess: () -> Unit) {
        MoviesDao.delete(item)
        onSuccess()
    }
}