package com.example.filmtest.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmtest.data.retrofit.RetrofitRepo
import com.example.filmtest.model.MovieModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel: ViewModel() {
    val repo = RetrofitRepo()
    val myMovies: MutableLiveData<Response<MovieModel>> = MutableLiveData()

    fun getMovies(){
        viewModelScope.launch {
            myMovies.value = repo.getMovies()
        }
    }
}
