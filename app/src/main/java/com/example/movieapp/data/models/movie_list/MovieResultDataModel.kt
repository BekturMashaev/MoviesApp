package com.example.movieapp.data.models.movie_list

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieResultDataModel(
    @SerializedName("adult")
    val isForAdults:Boolean,
    @SerializedName("id")
    val id:Int,
    @SerializedName("original_language")
    val language:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("overview")
    val overview:String,
    @SerializedName("popularity")
    val popularity:Double,
    @SerializedName("poster_path")
    val poster:String?,
    @SerializedName("release_date")
    val releaseDate:String,
    @SerializedName("vote_average")
    val voteAverage:Double,
    @SerializedName("vote_count")
    val voteCount:Int,
):Serializable{
    companion object{
        val unknown= MovieResultDataModel(
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
