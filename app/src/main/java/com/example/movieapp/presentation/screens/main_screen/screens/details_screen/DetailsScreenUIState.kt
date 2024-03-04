package com.example.movieapp.presentation.screens.main_screen.screens.details_screen

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.movieapp.presentation.models.movie_info.MovieInfoDataModelUI

@Immutable
sealed class DetailsScreenUIState {
    @Stable
    data class Loaded(
        val movie: MovieInfoDataModelUI
    ) : DetailsScreenUIState()

    data object Loading : DetailsScreenUIState()

    @Immutable
    data class Error(
        val message: String,
    ) : DetailsScreenUIState()
}