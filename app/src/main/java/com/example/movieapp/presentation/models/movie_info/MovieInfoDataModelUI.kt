package com.example.movieapp.presentation.models.movie_info

import java.io.Serializable


data class MovieInfoDataModelUI(
    val adult: Boolean,
    val backdropPath: String,
    val budget: Int,
    val genres: List<String>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val runtime: Int,
    val status: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    val country:List<String>
) : Serializable {
    companion object {
        val unknown = MovieInfoDataModelUI(
            adult = false,
            backdropPath = "",
            budget = 312321,
            genres = emptyList(),
            id = 0,
            originalLanguage = "",
            originalTitle = "",
            overview = "KO",
            popularity = 0.0,
            posterPath = "",
            releaseDate = "2005-23-24",
            runtime = 125,
            status = "2005-23-24",
            title = "Сверхестественное",
            video = false,
            voteAverage = 0.0,
            voteCount = 0,
            country = emptyList()
        )
    }
}