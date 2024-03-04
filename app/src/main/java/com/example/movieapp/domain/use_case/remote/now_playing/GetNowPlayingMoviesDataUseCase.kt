package com.example.movieapp.domain.use_case.remote.now_playing

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.models.movie_list.MoviesListDomainModel

interface GetNowPlayingMoviesDataUseCase {
    suspend operator fun invoke():ResultStatus<MoviesListDomainModel>
}