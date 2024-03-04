package com.example.movieapp.data.models.movie_info

import com.google.gson.annotations.SerializedName

data class ProductionCountries(
    @SerializedName("iso_3166_1")
    val name:String
)
