package com.example.movieapp.presentation.screens.main_screen.screens.home_screen

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.movieapp.presentation.models.movies_list.MovieResultUIModel
import kotlinx.collections.immutable.ImmutableList

@Immutable
sealed class HomeScreenUiState {

    @Stable
    data class Loaded(
        val popularMovies: ImmutableList<MovieResultUIModel>,
        val nowPlayingMovies: ImmutableList<MovieResultUIModel>,
        val topRatedMovies: ImmutableList<MovieResultUIModel>,
        val upcomingMovies: ImmutableList<MovieResultUIModel>,
    ) : HomeScreenUiState()

    data object Loading : HomeScreenUiState()

    @Immutable
    data class Error(
        val message: String,
    ) : HomeScreenUiState()
}