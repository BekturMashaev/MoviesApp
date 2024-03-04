package com.example.movieapp.domain.use_case.local.get_list

import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain
import kotlinx.coroutines.flow.Flow

interface GetSavedMoviesUseCase {
    suspend fun getAllSavedMovies(): Flow<List<MovieInfoDataModelDomain>>
}