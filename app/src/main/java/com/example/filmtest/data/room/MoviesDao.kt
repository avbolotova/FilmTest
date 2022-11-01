package com.example.filmtest.data.room

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.filmtest.model.Item

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from movie_table")
    fun getAllMovies() : LiveData<List<Item>>
}