package com.example.movieapp.presentation.screens.main_screen.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.base.models.ResponseStatus
import com.example.movieapp.domain.use_case.remote.now_playing.DefaultGetNowPlayingMoviesDataUseCase
import com.example.movieapp.domain.use_case.remote.popular.DefaultGetPopularMoviesDataUseCase
import com.example.movieapp.domain.use_case.remote.top_rated.DefaultGetTopRatedMoviesDataUseCase
import com.example.movieapp.domain.use_case.remote.upcoming.DefaultGetUpcomingMoviesDataUseCase
import com.example.movieapp.presentation.mappers.toUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getPopularMoviesDataUseCase: DefaultGetPopularMoviesDataUseCase,
    private val getNowPlayingMoviesDataUseCase: DefaultGetNowPlayingMoviesDataUseCase,
    private val getTopRatedMoviesDataUseCase: DefaultGetTopRatedMoviesDataUseCase,
    private val getUpcomingMoviesDataUseCase: DefaultGetUpcomingMoviesDataUseCase,
) : ViewModel() {
    private val _uiState: MutableStateFlow<HomeScreenUiState> =
        MutableStateFlow(HomeScreenUiState.Loading)
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()
    private val handle = CoroutineExceptionHandler { _, throwable -> }

    init {
        getAllMovies()
    }

    fun getAllMovies() {
        viewModelScope.launch(handle + Dispatchers.IO) {
            _uiState.update { HomeScreenUiState.Loading }
            val getPopularMoviesDataUseCaseDeferred = async { getPopularMoviesDataUseCase() }
            val getNowPlayingMoviesDataUseCaseDeferred = async { getNowPlayingMoviesDataUseCase() }
            val getTopRatedMoviesDataUseCaseDeferred = async { getTopRatedMoviesDataUseCase() }
            val getUpcomingMoviesDataUseCaseDeferred = async { getUpcomingMoviesDataUseCase() }
            val getPopularMoviesDataUseCase = getPopularMoviesDataUseCaseDeferred.await()
            val getNowPlayingMoviesDataUseCase = getNowPlayingMoviesDataUseCaseDeferred.await()
            val getTopRatedMoviesDataUseCase = getTopRatedMoviesDataUseCaseDeferred.await()
            val getUpcomingMoviesDataUseCase = getUpcomingMoviesDataUseCaseDeferred.await()
            if (getTopRatedMoviesDataUseCase.status == ResponseStatus.SUCCESS && getPopularMoviesDataUseCase.status == ResponseStatus.SUCCESS && getNowPlayingMoviesDataUseCase.status == ResponseStatus.SUCCESS && getUpcomingMoviesDataUseCase.status == ResponseStatus.SUCCESS) {
                getPopularMoviesDataUseCase.data.let { popular ->
                    getNowPlayingMoviesDataUseCase.data.let { nowPlaying ->
                        getTopRatedMoviesDataUseCase.data.let { topRated ->
                            getUpcomingMoviesDataUseCase.data.let { upcoming ->
                                if (popular != null && nowPlaying != null && topRated != null && upcoming != null) _uiState.update {
                                    HomeScreenUiState.Loaded(
                                        popularMovies = popular.results.map {
                                            it.toUIModel()
                                        }.toImmutableList(),
                                        nowPlayingMovies = nowPlaying.results.map {
                                            it.toUIModel()
                                        }.toImmutableList(),
                                        topRatedMovies = topRated.results.map {
                                            it.toUIModel()
                                        }.toImmutableList(),
                                        upcomingMovies = upcoming.results.map {
                                            it.toUIModel()
                                        }.toImmutableList()
                                    )
                                }
                            }
                        }
                    }
                }
            } else {
                _uiState.update {
                    HomeScreenUiState.Error(
                        message = "Something went wrong,please check internet connection or try again"
                    )
                }
            }
        }
    }
}