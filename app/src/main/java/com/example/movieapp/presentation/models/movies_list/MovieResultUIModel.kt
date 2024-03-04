package com.example.movieapp.presentation.models.movies_list

import androidx.compose.runtime.Immutable
import java.io.Serializable

@Immutable
data class MovieResultUIModel   (
    val isForAdults: Boolean,
    val id: Int,
    val language: String,
    val title: String,
    val overview: String,
    val popularity: Double,
    val poster: String?,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int,
) : Serializable {
    companion object {
        val unknown = MovieResultUIModel(
            isForAdults = false,
            id = 0,
            language = "EN",
            overview = "dde",
            popularity = 0.0,
            poster = "dde",
            releaseDate = "2023-23-2",
            voteAverage = 0.0,
            voteCount = 0,
            title = "Hayku"
        )
    }
}
