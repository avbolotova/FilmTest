package com.example.filmtest.view.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmtest.REALIZATION
import com.example.filmtest.model.Item
import kotlinx.coroutines.launch

class FavoriteFragmentViewModel: ViewModel() {

    fun getAllMoviesFav() : LiveData<List<Item>>{
        return REALIZATION.allMovies
    }

    fun deleteMovieFav(item: Item){
        viewModelScope.launch { REALIZATION.deleteMovie(item) {} }
    }



}