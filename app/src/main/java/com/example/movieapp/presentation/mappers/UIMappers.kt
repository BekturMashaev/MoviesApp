package com.example.movieapp.presentation.mappers

import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain
import com.example.movieapp.domain.models.movie_list.MovieResultDomainModel
import com.example.movieapp.presentation.models.movie_info.MovieInfoDataModelUI
import com.example.movieapp.presentation.models.movies_list.MovieResultUIModel

/** movieInfoModel **/
fun MovieInfoDataModelDomain.toUI() = MovieInfoDataModelUI(
    adult,
    backdropPath.orEmpty(),
    budget,
    genres = genres,
    id,
    originalLanguage,
    originalTitle,
    releaseDate = releaseDate,
    runtime = runtime,
    status = status,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount,
    popularity = popularity,
    posterPath = posterPath,
    overview = overview,
    country = country,
)

/** resultModel **/

fun MovieResultDomainModel.toUIModel() = MovieResultUIModel(
    isForAdults = isForAdults,
    id = id,
    language = language,
    title = title,
    overview = overview,
    popularity = popularity,
    poster = poster,
    releaseDate = releaseDate,
    voteAverage = voteAverage,
    voteCount = voteCount
)


/** from ui to domain **/

fun MovieInfoDataModelUI.toDomain() = MovieInfoDataModelDomain(
    adult,
    backdropPath.orEmpty(),
    budget,
    genres = genres,
    id,
    originalLanguage,
    originalTitle,
    releaseDate = releaseDate,
    runtime = runtime,
    status = status,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount,
    popularity = popularity,
    posterPath = posterPath,
    overview = overview,
    country = country,
)
