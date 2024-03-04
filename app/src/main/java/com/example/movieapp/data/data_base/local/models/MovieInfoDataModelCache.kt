//package com.example.movieapp.data.data_base.local.models
//
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//import java.io.Serializable
//
//
//private const val MOVIE_TABLE_NAME = "movie_table_name"
//private const val MOVIE_ADULT = "adult"
//private const val MOVIE_BACKDROP_PATH = "backdrop_path"
//private const val MOVIE_BUDGET = "budget"
//private const val MOVIE_GENRES = "genres"
//private const val MOVIE_ORIGINAL_LANGUAGE = "original_language"
//private const val MOVIE_ORIGINAL_TITLE = "original_title"
//private const val MOVIE_OVERVIEW = "overview"
//private const val MOVIE_POPULARITY = "popularity"
//private const val MOVIE_POSTER_PATH = "poster_path"
//private const val MOVIE_RELEASE_DATE = "release_date"
//private const val MOVIE_RUNTIME = "runtime"
//private const val MOVIE_STATUS = "status"
//private const val MOVIE_TITLE = "title"
//private const val MOVIE_VIDEO = "video"
//private const val MOVIE_VOTE_AVERAGE = "vote_average"
//private const val MOVIE_VOTE_COUNT = "vote_count"
//private const val MOVIE_PRODUCTION_COUNTRIES = "production_countries"
//
//@Entity(tableName = MOVIE_TABLE_NAME)
//data class MovieInfoDataModelCache(
//    @PrimaryKey val id: Int,
//    @ColumnInfo(name = MOVIE_ADULT)
//    val adult: Boolean,
//    @ColumnInfo(name = MOVIE_BACKDROP_PATH)
//    val backdropPath: String,
//    @ColumnInfo(name = MOVIE_BUDGET)
//    val budget: Int,
//    @ColumnInfo(name = MOVIE_GENRES)
//    val genres: List<String>,
//    @ColumnInfo(name = MOVIE_ORIGINAL_LANGUAGE)
//    val originalLanguage: String,
//    @ColumnInfo(name = MOVIE_ORIGINAL_TITLE)
//    val originalTitle: String,
//    @ColumnInfo(name = MOVIE_OVERVIEW)
//    val overview: String,
//    @ColumnInfo(name = MOVIE_POPULARITY)
//    val popularity: Double,
//    @ColumnInfo(name = MOVIE_POSTER_PATH)
//    val posterPath: String,
//    @ColumnInfo(name = MOVIE_RELEASE_DATE)
//    val releaseDate: String,
//    @ColumnInfo(name = MOVIE_RUNTIME)
//    val runtime: Int,
//    @ColumnInfo(name = MOVIE_STATUS)
//    val status: String,
//    @ColumnInfo(name = MOVIE_TITLE)
//    val title: String,
//    @ColumnInfo(name = MOVIE_VIDEO)
//    val video: Boolean,
//    @ColumnInfo(name = MOVIE_VOTE_AVERAGE)
//    val voteAverage: Double,
//    @ColumnInfo(name = MOVIE_VOTE_COUNT)
//    val voteCount: Int,
//    @ColumnInfo(name = MOVIE_PRODUCTION_COUNTRIES)
//    val country: List<String>
//) : Serializable
