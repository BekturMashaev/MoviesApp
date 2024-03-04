package com.example.movieapp.data.mappers

import com.example.movieapp.data.data_base.local.models.MovieInfoDataModelCache
import com.example.movieapp.data.models.movie_info.MovieInfoDataModel
import com.example.movieapp.data.models.movie_list.MovieResultDataModel
import com.example.movieapp.data.models.movie_list.MoviesListDataModel
import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain
import com.example.movieapp.domain.models.movie_list.MovieResultDomainModel
import com.example.movieapp.domain.models.movie_list.MoviesListDomainModel

/** from data to domain (result)**/
fun MovieResultDataModel.toDomainModel() = MovieResultDomainModel(
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

fun MoviesListDataModel.toDomainModel() = MoviesListDomainModel(
    results = results.map { it.toDomainModel() }
)

/** from data to domain (info)**/
fun MovieInfoDataModel.toDomain() = MovieInfoDataModelDomain(
    adult,
    backdropPath.orEmpty(),
    budget,
    genres = genres.map { it.name },
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
    country = country.map { it.name },
)

/** from cache to domain **/

fun MovieInfoDataModelDomain.toCache() = MovieInfoDataModelCache(
    adult = adult,
    backdropPath = backdropPath.orEmpty(),
    budget = budget,
    id = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
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
)

/** from domain to cache **/

fun MovieInfoDataModelCache.toDomain() = MovieInfoDataModelDomain(
    adult = adult,
    backdropPath = backdropPath.orEmpty(),
    budget = budget,
    genres = listOf(""),
    id = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
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
    country = listOf(""),
)

