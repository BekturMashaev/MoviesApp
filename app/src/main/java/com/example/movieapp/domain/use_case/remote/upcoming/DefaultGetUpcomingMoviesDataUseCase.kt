package com.example.movieapp.domain.use_case.remote.upcoming

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.models.movie_list.MoviesListDomainModel
import com.example.movieapp.domain.repository.GetMoviesDataRepository
import javax.inject.Inject

class DefaultGetUpcomingMoviesDataUseCase @Inject constructor(
    private val repository: GetMoviesDataRepository
): GetUpcomingMoviesDataUseCase {
    override suspend fun invoke(): ResultStatus<MoviesListDomainModel> {
        val response=repository.getUpcomingMovies()
        return ResultStatus(
            status = response.status,
            data = response.data,
            errorThrowable =response.errorThrowable
        )
    }

}