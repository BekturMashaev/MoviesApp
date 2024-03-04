package com.example.movieapp.presentation.screens.main_screen.screens.search_screen

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.movieapp.presentation.models.movies_list.MovieResultUIModel
import kotlinx.collections.immutable.ImmutableList


@Immutable
sealed class SearchScreenUIState {

    @Stable
    data class Loaded(
        val movies: ImmutableList<MovieResultUIModel>,
    ) : SearchScreenUIState()

    data object Loading : SearchScreenUIState()

    data object NoMovies : SearchScreenUIState()

    @Immutable
    data class Error(
        val message: String,
    ) : SearchScreenUIState()
}