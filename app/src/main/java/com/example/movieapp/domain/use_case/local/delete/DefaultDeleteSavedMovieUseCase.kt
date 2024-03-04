//package com.example.movieapp.domain.use_case.local.delete
//
//import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain
//import com.example.movieapp.domain.repository.GetMoviesDataRepository
//
//class DefaultDeleteSavedMovieUseCase(
//    private val repository: GetMoviesDataRepository
//):DeleteSavedMovieUseCase {
//    override suspend fun deleteMovie(id: Int) {
//        repository.deleteMovie(id)
//    }
//}