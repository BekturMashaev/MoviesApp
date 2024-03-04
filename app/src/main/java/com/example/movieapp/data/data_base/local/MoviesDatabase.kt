package com.example.movieapp.data.data_base.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieapp.data.data_base.local.models.MovieInfoDataModelCache

@Database(
    entities = [
        MovieInfoDataModelCache::class,
    ],
    version = 1,
    exportSchema = false
)

abstract class MoviesDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MoviesDAO
}