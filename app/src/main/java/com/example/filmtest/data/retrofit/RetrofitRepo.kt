package com.example.filmtest.data.retrofit

import com.example.filmtest.data.RetrofitInstance
import com.example.filmtest.model.MoviesModel
import retrofit2.Response

class RetrofitRepo {
    suspend fun getMovies(): Response<MoviesModel>{
        return RetrofitInstance.api.getPopularMovies()
    }
}