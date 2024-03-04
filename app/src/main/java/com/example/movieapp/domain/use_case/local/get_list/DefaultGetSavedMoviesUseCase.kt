package com.example.movieapp.domain.use_case.local.get_list

import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain
import com.example.movieapp.domain.repository.GetMoviesDataRepository
import kotlinx.coroutines.flow.Flow

class DefaultGetSavedMoviesUseCase(
    private val repository: GetMoviesDataRepository
): GetSavedMoviesUseCase {
    override suspend fun getAllSavedMovies(): Flow<List<MovieInfoDataModelDomain>> {
        return repository.getAllSavedMovies()
    }
}