package com.example.movieapp.domain.use_case.remote.movie_info

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain

interface GetMovieInfoUseCase {
    suspend operator fun invoke(movieId: Int): ResultStatus<MovieInfoDataModelDomain>
}