package com.example.movieapp.di

import android.content.Context
import androidx.room.Room
import com.example.movieapp.data.data_base.local.MoviesDAO
import com.example.movieapp.data.data_base.local.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
const val MOVIES_DATABASE_NAME = "MoviesDatabase"
@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    @Provides
    fun provideRoomDataBase(
        @ApplicationContext context: Context
    ): MoviesDatabase = Room.databaseBuilder(
        context,
        MoviesDatabase::class.java,
        MOVIES_DATABASE_NAME
    ).build()
    @Provides
    fun provideMoviesDao(database: MoviesDatabase): MoviesDAO = database.getMovieDao()
}