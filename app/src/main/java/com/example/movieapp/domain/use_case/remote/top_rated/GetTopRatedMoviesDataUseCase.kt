package com.example.movieapp.domain.use_case.remote.top_rated

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.models.movie_list.MoviesListDomainModel

interface GetTopRatedMoviesDataUseCase {
    suspend operator fun invoke():ResultStatus<MoviesListDomainModel>
}