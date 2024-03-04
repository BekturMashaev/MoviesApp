package com.example.movieapp.data.models.movie_list

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MoviesListDataModel(
    @SerializedName("results")
    val results: List<MovieResultDataModel>,
) : Serializable {
    companion object {
        val unknown = MoviesListDataModel(
            results = listOf(
                MovieResultDataModel.unknown
            ),
        )
    }
}
