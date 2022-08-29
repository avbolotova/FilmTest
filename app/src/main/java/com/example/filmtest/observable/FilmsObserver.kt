package com.example.filmtest.observable

import com.example.filmtest.main.Films

interface FilmsObserver {
    fun onFilmsChanged(films: List<Films>)
}