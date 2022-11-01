package com.example.filmtest.view.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.filmtest.REALIZATION
import com.example.filmtest.data.repository.MoviesRealisation
import com.example.filmtest.data.retrofit.RetrofitRepo
import com.example.filmtest.data.room.MoviesRoomDatabase
import com.example.filmtest.model.MovieModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    val repo = RetrofitRepo()
    val myMovies: MutableLiveData<Response<MovieModel>> = MutableLiveData()
    val context = application

    fun getMovies(){
        viewModelScope.launch {
            myMovies.value = repo.getMovies()
        }
    }
    fun initDatabase(){
        val daoMovie = MoviesRoomDatabase.getInstance(context).getMoviesDao()
        REALIZATION = MoviesRealisation(daoMovie)
    }
}
