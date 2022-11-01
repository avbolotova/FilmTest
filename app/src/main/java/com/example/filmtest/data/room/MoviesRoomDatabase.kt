package com.example.filmtest.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.filmtest.model.Item

@Database(entities = [Item::class], version = 2)
abstract class MoviesRoomDatabase : RoomDatabase() {

    abstract fun getMoviesDao(): MoviesDao

    companion object{
        private var database: MoviesRoomDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): MoviesRoomDatabase {
            return if (database == null) {
                database = Room
                    .databaseBuilder(context, MoviesRoomDatabase::class.java, "db")
                    .build()
                database as MoviesRoomDatabase
            } else {
                database as MoviesRoomDatabase
            }
        }
    }
}
