package com.example.movieapp.presentation.models.movie_info


import java.io.Serializable

data class GenreUI(
    val id: Int,
    val name: String
) : Serializable {
    companion object {
        val unknown = GenreUI(
            0,
            ""
        )
    }
}