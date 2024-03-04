package com.example.movieapp.presentation.screens.main_screen.screens.home_screen

import android.annotation.SuppressLint
import androidx.activity.addCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.movieapp.R
import com.example.movieapp.presentation.components.common.error_screen.ErrorScreen
import com.example.movieapp.presentation.components.common.loading.screen.LoadingScreen
import com.example.movieapp.presentation.components.main_screen_components.home_screen_components.MoviesCategoryTitle
import com.example.movieapp.presentation.components.main_screen_components.home_screen_components.MoviesListLazyRow
import com.example.movieapp.presentation.components.main_screen_components.home_screen_components.PopularMoviesPager
import com.example.movieapp.presentation.theme.BlackBackgroundColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onBackPressedCallback: () -> Unit,
    onNavigateToInfo: (Int) -> Unit,
    uiStateFlowMovie: HomeScreenUiState,
    tryAgainCallBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when (uiStateFlowMovie) {
        is HomeScreenUiState.Loading -> LoadingScreen()
        is HomeScreenUiState.Loaded -> {
            val backStackDispatcher = LocalOnBackPressedDispatcherOwner.current
            backStackDispatcher?.onBackPressedDispatcher?.addCallback {
                onBackPressedCallback()
            }
            Column(
                modifier = modifier
                    .verticalScroll(rememberScrollState())
                    .background(BlackBackgroundColor)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                PopularMoviesPager(
                    list = uiStateFlowMovie.popularMovies,
                    onNavigateToInfo=onNavigateToInfo
                )
                MoviesCategoryTitle(text = stringResource(R.string.toprated_movies))
                MoviesListLazyRow(
                    moviesList = uiStateFlowMovie.topRatedMovies,
                    onNavigateToInfo = onNavigateToInfo
                )
                MoviesCategoryTitle(text = stringResource(R.string.upcoming_movies))
                MoviesListLazyRow(
                    moviesList = uiStateFlowMovie.upcomingMovies,
                    onNavigateToInfo = onNavigateToInfo
                )
                MoviesCategoryTitle(text = stringResource(R.string.nowplaying_movies))
                MoviesListLazyRow(
                    moviesList = uiStateFlowMovie.nowPlayingMovies,
                    onNavigateToInfo = onNavigateToInfo
                )
            }
        }

        is HomeScreenUiState.Error -> ErrorScreen(message = uiStateFlowMovie.message) {
            tryAgainCallBack()
        }
    }
}
