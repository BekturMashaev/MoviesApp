package com.example.movieapp.di

import com.example.movieapp.domain.repository.GetMoviesDataRepository
import com.example.movieapp.domain.use_case.local.add.AddMovieUseCase
import com.example.movieapp.domain.use_case.local.add.DefaultAddMovieUseCase
import com.example.movieapp.domain.use_case.local.delete.DefaultDeleteSavedMovieUseCase
import com.example.movieapp.domain.use_case.local.delete.DeleteSavedMovieUseCase
import com.example.movieapp.domain.use_case.local.get_list.DefaultGetSavedMoviesUseCase
import com.example.movieapp.domain.use_case.local.get_list.GetSavedMoviesUseCase
import com.example.movieapp.domain.use_case.local.get_movie.DefaultGetSavedMovieByIdUseCase
import com.example.movieapp.domain.use_case.local.get_movie.GetSavedMovieByIdUseCase
import com.example.movieapp.domain.use_case.remote.movie_info.DefaultGetMovieInfoUseCase
import com.example.movieapp.domain.use_case.remote.movie_info.GetMovieInfoUseCase
import com.example.movieapp.domain.use_case.remote.now_playing.DefaultGetNowPlayingMoviesDataUseCase
import com.example.movieapp.domain.use_case.remote.now_playing.GetNowPlayingMoviesDataUseCase
import com.example.movieapp.domain.use_case.remote.popular.DefaultGetPopularMoviesDataUseCase
import com.example.movieapp.domain.use_case.remote.popular.GetPopularMoviesDataUseCase
import com.example.movieapp.domain.use_case.remote.searched.DefaultGetSearchedMoviesUseCase
import com.example.movieapp.domain.use_case.remote.searched.GetSearchedMoviesUseCase
import com.example.movieapp.domain.use_case.remote.top_rated.DefaultGetTopRatedMoviesDataUseCase
import com.example.movieapp.domain.use_case.remote.top_rated.GetTopRatedMoviesDataUseCase
import com.example.movieapp.domain.use_case.remote.upcoming.DefaultGetUpcomingMoviesDataUseCase
import com.example.movieapp.domain.use_case.remote.upcoming.GetUpcomingMoviesDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideGetNowPlayingMoviesUseCase(
        repository: GetMoviesDataRepository
    ): GetNowPlayingMoviesDataUseCase = DefaultGetNowPlayingMoviesDataUseCase(repository)

    @Provides
    fun provideGetPopularMoviesUseCase(
        repository: GetMoviesDataRepository
    ): GetPopularMoviesDataUseCase = DefaultGetPopularMoviesDataUseCase(repository)

    @Provides
    fun provideGetTopRatedMoviesUseCase(
        repository: GetMoviesDataRepository
    ): GetTopRatedMoviesDataUseCase = DefaultGetTopRatedMoviesDataUseCase(repository)

    @Provides
    fun provideGetUpcomingMoviesUseCase(
        repository: GetMoviesDataRepository
    ): GetUpcomingMoviesDataUseCase = DefaultGetUpcomingMoviesDataUseCase(repository)

    @Provides
    fun provideGetSearchedMoviesUseCase(
        repository: GetMoviesDataRepository
    ): GetSearchedMoviesUseCase = DefaultGetSearchedMoviesUseCase(repository)

    @Provides
    fun provideGetMovieInfoUseCase(
        repository: GetMoviesDataRepository,
    ): GetMovieInfoUseCase = DefaultGetMovieInfoUseCase(repository)

    @Provides
    fun provideAddNewMovie(
        repository: GetMoviesDataRepository,
    ): AddMovieUseCase = DefaultAddMovieUseCase(repository)

    @Provides
    fun provideGDeleteSavedMovieUseCase(
        repository: GetMoviesDataRepository,
    ): DeleteSavedMovieUseCase = DefaultDeleteSavedMovieUseCase(repository)

    @Provides
    fun provideGetSavedMoviesUseCase(
        repository: GetMoviesDataRepository,
    ): GetSavedMoviesUseCase = DefaultGetSavedMoviesUseCase(repository)

    @Provides
    fun provideGetSavedMovieByIdUseCase(
        repository: GetMoviesDataRepository,
    ): GetSavedMovieByIdUseCase = DefaultGetSavedMovieByIdUseCase(repository)
}