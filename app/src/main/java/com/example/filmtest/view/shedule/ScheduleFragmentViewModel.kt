package com.example.filmtest.view.shedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmtest.REALIZATION
import com.example.filmtest.model.Item
import kotlinx.coroutines.launch

class ScheduleFragmentViewModel : ViewModel() {

    fun getAllMoviesSched() : LiveData<List<Item>> {
        return REALIZATION.allMovies
    }

    fun deleteMoviesSched(item: Item){
        viewModelScope.launch { REALIZATION.deleteMovie(item) {} }
    }



}