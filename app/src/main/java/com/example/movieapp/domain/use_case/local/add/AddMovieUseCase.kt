package com.example.movieapp.domain.use_case.local.add

import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain

interface AddMovieUseCase {
    suspend fun addNewMovie(movieModel: MovieInfoDataModelDomain)
}