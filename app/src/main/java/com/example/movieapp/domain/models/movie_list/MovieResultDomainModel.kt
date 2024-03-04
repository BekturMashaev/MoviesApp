package com.example.movieapp.domain.models.movie_list

import java.io.Serializable

data class MovieResultDomainModel(
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
        val unknown = MovieResultDomainModel(
            isForAdults = false,
            id = 0,
            language = "",
            overview = "",
            popularity = 0.0,
            poster = "",
            releaseDate = "",
            voteAverage = 0.0,
            voteCount = 0,
            title = ""
        )
    }
}
