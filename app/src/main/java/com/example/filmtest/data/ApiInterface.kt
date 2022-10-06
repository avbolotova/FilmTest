package com.example.filmtest.data

import com.example.filmtest.model.MovieModel
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    @GET("3/movie/popular?api_key=28e80cae5eb9c2a8a6e57c823771f032&language=en-US&page=1")
    suspend fun getPopularMovies():Response<MovieModel>

}

