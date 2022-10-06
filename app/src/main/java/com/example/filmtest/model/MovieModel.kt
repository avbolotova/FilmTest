package com.example.filmtest.model

data class MovieModel(
    val page: Int,
    val results: List<Item>,
    val total_pages: Int,
    val total_results: Int
)