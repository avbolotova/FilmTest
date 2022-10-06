package com.example.filmtest.data.retrofit

import com.example.filmtest.data.RetrofitInstance
import com.example.filmtest.model.MovieModel
import retrofit2.Response

class RetrofitRepo {
    suspend fun getMovies(): Response<MovieModel>{
        return RetrofitInstance.api.getPopularMovies()
    }
}