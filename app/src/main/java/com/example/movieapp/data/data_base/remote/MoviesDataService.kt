package com.example.movieapp.data.data_base.remote

import com.example.movieapp.data.models.movie_list.MoviesListDataModel
import com.example.movieapp.data.models.movie_info.MovieInfoDataModel
import com.example.movieapp.data.utils.Constants.GET_MOVIE_INFO
import com.example.movieapp.data.utils.Constants.GET_NOW_PLAYING_MOVIES
import com.example.movieapp.data.utils.Constants.GET_POPULAR_MOVIES
import com.example.movieapp.data.utils.Constants.GET_SEARCHED_MOVIES
import com.example.movieapp.data.utils.Constants.GET_TOP_RATED_MOVIES
import com.example.movieapp.data.utils.Constants.GET_UPCOMING_MOVIES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesDataService {
    @GET(GET_NOW_PLAYING_MOVIES)
    suspend fun getNowPlayingMovies(): Response<MoviesListDataModel>

    @GET(GET_POPULAR_MOVIES)
    suspend fun getPopularMovies(): Response<MoviesListDataModel>

    @GET(GET_TOP_RATED_MOVIES)
    suspend fun getTopRatedMovies(): Response<MoviesListDataModel>

    @GET(GET_UPCOMING_MOVIES)
    suspend fun getGetUpcomingMovies(): Response<MoviesListDataModel>

    @GET(GET_MOVIE_INFO)
    suspend fun getMovieInfo(
        @Path("movie_id")movieId:Int
    ):Response<MovieInfoDataModel>

    @GET(GET_SEARCHED_MOVIES)
    suspend fun getSearchedMovies(
        @Query("query") query: String,
    ):Response<MoviesListDataModel>
}