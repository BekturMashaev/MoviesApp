package com.example.movieapp.domain.use_case.remote.movie_info

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain
import com.example.movieapp.domain.repository.GetMoviesDataRepository
import javax.inject.Inject

class DefaultGetMovieInfoUseCase @Inject constructor(
    private val repository: GetMoviesDataRepository,
) : GetMovieInfoUseCase {

    override suspend fun invoke(movieId: Int): ResultStatus<MovieInfoDataModelDomain> {
        val response = repository.getMovieInfo(movieId)
        return ResultStatus(
            status = response.status,
            data = response.data,
            errorThrowable = response.errorThrowable
        )
    }
}