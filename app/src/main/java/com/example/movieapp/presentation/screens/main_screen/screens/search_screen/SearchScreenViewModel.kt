package com.example.movieapp.presentation.screens.main_screen.screens.search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.base.models.ResponseStatus
import com.example.movieapp.domain.use_case.remote.searched.DefaultGetSearchedMoviesUseCase
import com.example.movieapp.presentation.mappers.toUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val getSearchedMoviesUseCase: DefaultGetSearchedMoviesUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<SearchScreenUIState> =
        MutableStateFlow(SearchScreenUIState.Loading)
    val uiState: StateFlow<SearchScreenUIState> = _uiState.asStateFlow()
    private val handle = CoroutineExceptionHandler { _, throwable -> }

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _hasStarted = MutableStateFlow(false)
    val hasStarted = _hasStarted.asStateFlow()

    init {
        _searchText
            .onEach(::getSearchedMovies)
            .launchIn(viewModelScope)
    }

    fun getSearchedMovies(text: String) {
        _searchText.value = text
        viewModelScope.launch(handle + Dispatchers.IO) {
            _uiState.update { SearchScreenUIState.Loading }
            val getSearchedMoviesUseCaseDeferred =
                async { getSearchedMoviesUseCase(_searchText.value) }
            val getSearchedMoviesDataUseCase = getSearchedMoviesUseCaseDeferred.await()
            if (getSearchedMoviesDataUseCase.status == ResponseStatus.SUCCESS) {
                getSearchedMoviesDataUseCase.data.let { movies ->
                    if (movies?.results?.isEmpty() == false) {
                        _uiState.update {
                            SearchScreenUIState.Loaded(
                                movies = movies.results.map {
                                    it.toUIModel()
                                }.toImmutableList()
                            )
                        }
                    } else {
                        _uiState.update { SearchScreenUIState.NoMovies }
                    }
                }
            } else {
                _uiState.update {
                    SearchScreenUIState.Error(
                        message = "Something went wrong,please check internet connection or try again"
                    )
                }
            }
        }
    }

    fun tryAgainCallBack() {
        getSearchedMovies(_searchText.value)
    }
}