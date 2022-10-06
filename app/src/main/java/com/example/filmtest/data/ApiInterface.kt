package com.example.filmtest.data

import com.example.filmtest.model.FilmsModel
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    @GET("en/API/MostPopularMovies/k_tmpzsh96")
    suspend fun getPopularMovies():Response<FilmsModel>

}

