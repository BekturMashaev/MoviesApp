package com.example.movieapp.domain.use_case.remote.popular

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.models.movie_list.MoviesListDomainModel

interface GetPopularMoviesDataUseCase {
    suspend operator fun invoke():ResultStatus<MoviesListDomainModel>
}