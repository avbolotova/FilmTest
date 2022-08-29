package com.example.filmtest.main

import androidx.annotation.DrawableRes

data class Films(
    val title: String,
    val description: String,
    @DrawableRes
    val imageResId: Int,
    val isFavorite: Boolean
)