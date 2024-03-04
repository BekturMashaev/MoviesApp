//package com.example.movieapp.domain.use_case.local.add
//
//import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain
//import com.example.movieapp.domain.repository.GetMoviesDataRepository
//
//class DefaultAddMovieUseCase(
//    private val repository: GetMoviesDataRepository,
//) : AddMovieUseCase {
//
//    override suspend fun addNewMovie(movieModel: MovieInfoDataModelDomain) {
//        repository.addMovie(movieModel)
//    }
//
//}