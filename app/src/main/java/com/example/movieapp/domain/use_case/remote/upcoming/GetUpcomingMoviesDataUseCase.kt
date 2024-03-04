package com.example.movieapp.domain.use_case.remote.upcoming

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.models.movie_list.MoviesListDomainModel

interface GetUpcomingMoviesDataUseCase {
    suspend operator fun invoke():ResultStatus<MoviesListDomainModel>
}