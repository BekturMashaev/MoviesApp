package com.example.movieapp.domain.use_case.remote.popular

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.models.movie_list.MoviesListDomainModel
import com.example.movieapp.domain.repository.GetMoviesDataRepository
import javax.inject.Inject

class DefaultGetPopularMoviesDataUseCase @Inject constructor(
    private val repository: GetMoviesDataRepository
) : GetPopularMoviesDataUseCase {
    override suspend fun invoke(): ResultStatus<MoviesListDomainModel> {
        return repository.getPopularMovies()
    }
}