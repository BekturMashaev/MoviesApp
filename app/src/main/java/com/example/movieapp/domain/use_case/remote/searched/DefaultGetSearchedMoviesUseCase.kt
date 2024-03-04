package com.example.movieapp.domain.use_case.remote.searched

import android.util.Log
import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.models.movie_list.MoviesListDomainModel
import com.example.movieapp.domain.repository.GetMoviesDataRepository
import javax.inject.Inject

class DefaultGetSearchedMoviesUseCase @Inject constructor(
    private val repository: GetMoviesDataRepository
) : GetSearchedMoviesUseCase {
    override suspend fun invoke(query: String): ResultStatus<MoviesListDomainModel> {
        val response = repository.getSearchedMovies(query = query)
        return ResultStatus(
            status = response.status,
            data = response.data,
            errorThrowable = response.errorThrowable
        )
    }
}