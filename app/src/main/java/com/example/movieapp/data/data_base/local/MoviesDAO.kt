package com.example.movieapp.data.data_base.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.data_base.local.models.MovieInfoDataModelCache
import kotlinx.coroutines.flow.Flow


@Dao
interface MoviesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovie(movieModelCache: MovieInfoDataModelCache)

    @Query("SELECT * FROM movie_table_name")
    fun getAllSavedMovies(): Flow<List<MovieInfoDataModelCache>>

    @Query("SELECT * FROM movie_table_name WHERE id=:id")
    suspend fun getMovieById(id: Int): MovieInfoDataModelCache?

    @Query("DELETE  FROM movie_table_name WHERE id = :movieId")
    suspend fun deleteMovieById(movieId: Int)
}