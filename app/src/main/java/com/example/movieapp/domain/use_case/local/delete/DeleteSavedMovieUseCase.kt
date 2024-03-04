package com.example.movieapp.domain.use_case.local.delete

import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain

interface DeleteSavedMovieUseCase {
    suspend fun deleteMovie(id: Int)
}