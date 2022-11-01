package com.example.filmtest.view.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.filmtest.REALIZATION
import com.example.filmtest.model.Item

class FavoriteFragmentViewModel: ViewModel() {

    fun getAllMoviesFav() : LiveData<List<Item>>{
        return REALIZATION.allMovies
    }
}