package com.example.filmtest.model



import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie_table")
data class Item(
    @PrimaryKey(autoGenerate = true)
    var numId: Int = 1,
    val crew: String,
    val fullTitle: String,
    val imDbRating: String,
    val id: String,
    val imDbRatingCount: String,
    val image: String,
    val rank: String,
    val rankUpDown: String,
    val title: String,
    val year: String

) : Serializable