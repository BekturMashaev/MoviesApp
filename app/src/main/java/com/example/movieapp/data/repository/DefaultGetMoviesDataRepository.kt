package com.example.movieapp.data.repository

import com.example.movieapp.data.base.BaseDataSource
import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.data.data_base.local.MoviesDAO
import com.example.movieapp.data.data_base.remote.MoviesDataService
import com.example.movieapp.data.mappers.toCache
import com.example.movieapp.data.mappers.toDomain
import com.example.movieapp.data.mappers.toDomainModel
import com.example.movieapp.domain.models.movie_info.MovieInfoDataModelDomain
import com.example.movieapp.domain.models.movie_list.MoviesListDomainModel
import com.example.movieapp.domain.repository.GetMoviesDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultGetMoviesDataRepository @Inject constructor(
    private val service: MoviesDataService,
    private val dao: MoviesDAO
) : GetMoviesDataRepository, BaseDataSource() {
    override suspend fun getNowPlayingMovies(
    ): ResultStatus<MoviesListDomainModel> {
        val response = invokeResponseRequest { service.getNowPlayingMovies() }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomainModel(),
            errorThrowable = response.errorThrowable,
        )
    }

    override suspend fun getTopRatedMovies(): ResultStatus<MoviesListDomainModel> {
        val response = invokeResponseRequest { service.getTopRatedMovies() }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomainModel(),
            errorThrowable = response.errorThrowable,
        )
    }

    override suspend fun getUpcomingMovies(): ResultStatus<MoviesListDomainModel> {
        val response = invokeResponseRequest { service.getGetUpcomingMovies() }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomainModel(),
            errorThrowable = response.errorThrowable,
        )
    }

    override suspend fun getPopularMovies(): ResultStatus<MoviesListDomainModel> {
        val response = invokeResponseRequest { service.getPopularMovies() }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomainModel(),
            errorThrowable = response.errorThrowable,
        )
    }

    override suspend fun getMovieInfo(
        movieId: Int
    ): ResultStatus<MovieInfoDataModelDomain> {
        val response = invokeResponseRequest {
            service.getMovieInfo(
                movieId = movieId
            )
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomain(),
            errorThrowable = response.errorThrowable
        )
    }

    override suspend fun getSearchedMovies(query: String): ResultStatus<MoviesListDomainModel> {
        val response = invokeResponseRequest {
            service.getSearchedMovies(
                query = query
            )
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomainModel(),
            errorThrowable = response.errorThrowable
        )

    }

    override suspend fun addMovie(movieModelCache: MovieInfoDataModelDomain) {
        dao.addMovie(movieModelCache.toCache())
    }

    override fun getAllSavedMovies(): Flow<List<MovieInfoDataModelDomain>> {
        return dao.getAllSavedMovies().map { it.map { it.toDomain() }}
    }

    override suspend fun getMovieById(id: Int): MovieInfoDataModelDomain? {
        return dao.getMovieById(id)?.toDomain()
    }

    override suspend fun deleteMovie(id: Int) {
        dao.deleteMovieById(id)
    }

}