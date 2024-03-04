package com.example.movieapp.domain.use_case.local.get_movie

import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain
import com.example.movieapp.domain.repository.GetMoviesDataRepository
//
//class DefaultGetSavedMovieByIdUseCase(
//    private val repository: GetMoviesDataRepository
//) : GetSavedMovieByIdUseCase {
//    override suspend fun invoke(movieId: Int): MovieInfoDataModelDomain? {
//        return repository.getMovieById(movieId)
//    }
//}