package com.example.movieapp.domain.models.movie_list

import java.io.Serializable

data class MoviesListDomainModel(
    val results: List<MovieResultDomainModel>,
) : Serializable {
    companion object {
        val unknown = MoviesListDomainModel(
            results = listOf(
                MovieResultDomainModel.unknown
            ),
        )
    }
}
