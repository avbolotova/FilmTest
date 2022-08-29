package com.example.filmtest.repo

import android.content.Context
import com.example.filmtest.observable.FilmsObservable
import com.example.filmtest.R
import com.example.filmtest.main.Films

object FilmsRepo : FilmsObservable() {
    private var flm: MutableList<Films> = mutableListOf()
    val films: List<Films>
        get() = flm

    override fun notifyObservers() {
        observers.forEach {
            it.onFilmsChanged(films)
        }
    }


    fun createFilms(context: Context) {
        val films = mutableListOf<Films>(
            Films(
                title = "Интерстеллар",
                description = context.getString(R.string.descriptionOne),
                imageResId = R.drawable.interstellar,
                isFavorite = false
            ),
            Films(
                title = "Форест Гамп",
                description = context.getString(R.string.descriptionTwo),
                imageResId = R.drawable.forrest_gump,
                isFavorite = false
                ),
            Films(
                title = "Зеленая миля",
                description = context.getString(R.string.descriptionThree),
                imageResId = R.drawable.green_mile,
                isFavorite = false
                ),
            Films(
                title = "Начало",
                description = context.getString(R.string.descriptionFour),
                imageResId = R.drawable.inceptoin,
                isFavorite = false
            ),
            Films(
                title = "Судья",
                description = context.getString(R.string.descriptionFive),
                imageResId = R.drawable.sudia,
                isFavorite = false
            ),
            Films(
                title = "Один плюс Один",
                description = context.getString(R.string.descriptionSix),
                imageResId = R.drawable.onetoone,
                isFavorite = false
            )
        )
        flm = films
    }


    fun setFilmsFavorite(films: Films) {
        val index = flm.indexOf(films)
        val newMovie = films.copy(isFavorite = !films.isFavorite)
        flm[index] = newMovie
        notifyObservers()
    }

    fun getFavoriteFilms(): List<Films> {
        val favoriteFilms = films.filter { flms -> flms.isFavorite }
        return favoriteFilms
    }

    fun deleteFromFavorites(flms: Films) {
        val index = flm.indexOf(flms)
        val newMovie = flms.copy(isFavorite = false)
        flm[index] = newMovie
        notifyObservers()
    }
}