package com.example.movieapp.presentation.screens.main_screen.screens.details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.base.models.ResponseStatus
import com.example.movieapp.domain.use_case.local.add.DefaultAddMovieUseCase
import com.example.movieapp.domain.use_case.remote.movie_info.DefaultGetMovieInfoUseCase
import com.example.movieapp.presentation.mappers.toDomain
import com.example.movieapp.presentation.mappers.toUI
import com.example.movieapp.presentation.models.movie_info.MovieInfoDataModelUI
import dagger.hilt.android.lifecycle.HiltViewModel
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
class DetailsScreenViewModel @Inject constructor(
    private val getMovieInfoUseCase: DefaultGetMovieInfoUseCase,
    private val addMovieToLibrary:DefaultAddMovieUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<DetailsScreenUIState> =
        MutableStateFlow(DetailsScreenUIState.Loading)
    val uiState: StateFlow<DetailsScreenUIState> = _uiState.asStateFlow()
    private val handle = CoroutineExceptionHandler { _, throwable -> }

    fun addMovie(movie:MovieInfoDataModelUI){
        viewModelScope.launch(handle + Dispatchers.IO) {
            addMovieToLibrary.addNewMovie(movie.toDomain())
        }
    }
    fun getMovieInfo(
        movieId: Int,
    ) {
        viewModelScope.launch(handle + Dispatchers.IO) {
            _uiState.update { DetailsScreenUIState.Loading }
            val getMovieInfoUseCaseDeferred = async {
                getMovieInfoUseCase(movieId = movieId)
            }
            val getMovieInfoUseCase = getMovieInfoUseCaseDeferred.await()
            if (getMovieInfoUseCase.status == ResponseStatus.SUCCESS) {
                getMovieInfoUseCase.data.let { movieDetails ->
                    if (movieDetails != null) {
                        _uiState.update {
                            DetailsScreenUIState.Loaded(
                                movie = movieDetails.toUI()
                            )
                        }
                    }
                }
            } else {
                _uiState.update {
                    DetailsScreenUIState.Error(
                        message = "Something went wrong,please check internet connection or try again"
                    )
                }
            }
        }
    }
}