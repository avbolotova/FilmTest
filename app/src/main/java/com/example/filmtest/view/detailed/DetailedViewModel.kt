package com.example.filmtest.view.detailed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmtest.REALIZATION
import com.example.filmtest.data.repository.MoviesRealisation
import com.example.filmtest.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailedViewModel: ViewModel() {

    fun insert(item: Item, onSuccess:() -> Unit) = viewModelScope.launch (Dispatchers.IO) {
        REALIZATION.insertMovie(item) {
            onSuccess()
        }
    }

    fun delete(item: Item, onSuccess:() -> Unit) = viewModelScope.launch (Dispatchers.IO) {
        REALIZATION.deleteMovie(item) {
            onSuccess()
        }
    }
}