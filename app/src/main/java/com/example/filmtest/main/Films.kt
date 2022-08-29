package com.example.filmtest.main

import androidx.annotation.DrawableRes
import java.io.Serializable

data class Films (
    val title: String,
    val description: String,
    @DrawableRes
    val imageResId: Int,
    val isFavorite: Boolean
) : Serializable