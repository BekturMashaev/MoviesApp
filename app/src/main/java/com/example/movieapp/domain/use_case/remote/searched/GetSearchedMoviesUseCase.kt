package com.example.movieapp.domain.use_case.remote.searched

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.models.movie_list.MoviesListDomainModel

interface GetSearchedMoviesUseCase {
    suspend operator fun invoke(query:String):ResultStatus<MoviesListDomainModel>
}