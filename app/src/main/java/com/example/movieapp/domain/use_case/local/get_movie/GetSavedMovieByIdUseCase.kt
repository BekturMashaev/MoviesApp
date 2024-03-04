package com.example.movieapp.domain.use_case.local.get_movie

import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain

interface GetSavedMovieByIdUseCase {
    suspend operator fun invoke(movieId: Int): MovieInfoDataModelDomain?
}