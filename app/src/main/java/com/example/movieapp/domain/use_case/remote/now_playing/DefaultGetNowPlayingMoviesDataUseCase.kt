package com.example.movieapp.domain.use_case.remote.now_playing

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.models.movie_list.MoviesListDomainModel
import com.example.movieapp.domain.repository.GetMoviesDataRepository
import javax.inject.Inject

class DefaultGetNowPlayingMoviesDataUseCase @Inject constructor(
    private val repository: GetMoviesDataRepository
) : GetNowPlayingMoviesDataUseCase {
    override suspend fun invoke(): ResultStatus<MoviesListDomainModel> {
        val response = repository.getNowPlayingMovies()
        return ResultStatus(
            status = response.status,
            data = response.data,
            errorThrowable = response.errorThrowable
        )
    }
}