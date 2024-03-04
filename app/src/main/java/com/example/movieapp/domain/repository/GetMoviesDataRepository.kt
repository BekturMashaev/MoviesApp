package com.example.movieapp.domain.repository

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain
import com.example.movieapp.domain.models.movie_list.MoviesListDomainModel

interface GetMoviesDataRepository {
    /** remote **/
    suspend fun getNowPlayingMovies(): ResultStatus<MoviesListDomainModel>

    suspend fun getTopRatedMovies(): ResultStatus<MoviesListDomainModel>

    suspend fun getUpcomingMovies(): ResultStatus<MoviesListDomainModel>

    suspend fun getPopularMovies(): ResultStatus<MoviesListDomainModel>

    suspend fun getMovieInfo(movieId:Int): ResultStatus<MovieInfoDataModelDomain>

    suspend fun getSearchedMovies(query:String): ResultStatus<MoviesListDomainModel>

    /** local **/
//    suspend fun addMovie(movieModelCache: MovieInfoDataModelDomain)
//
//    fun getAllSavedMovies(): Flow<List<MovieInfoDataModelDomain>>
//
//    suspend fun getMovieById(id: Int): MovieInfoDataModelDomain?
//
//    suspend fun deleteMovie(id: Int)
}