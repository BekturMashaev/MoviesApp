package com.example.movieapp.presentation.screens.main_screen.screens.search_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.movieapp.R
import com.example.movieapp.presentation.components.common.error_screen.ErrorScreen
import com.example.movieapp.presentation.components.common.loading.screen.LoadingScreen
import com.example.movieapp.presentation.components.main_screen_components.search_and_library_screens_components.MovieSearchItem
import com.example.movieapp.presentation.theme.BlackBackgroundColor
import com.example.movieapp.presentation.theme.RedButton
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.dp2
import com.example.movieapp.presentation.theme.dp20
import com.example.movieapp.presentation.theme.sp16

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    uiStateFlowMovie: SearchScreenUIState,
    onGetSearchedMovies: (String) -> Unit,
    query: String,
    onNavigateToInfo: (Int) -> Unit,
    tryAgainCallBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(BlackBackgroundColor)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(
            onGetSearchedMovies = onGetSearchedMovies,
            query = query
        )
        when (uiStateFlowMovie) {
            is SearchScreenUIState.Error -> ErrorScreen(
                message = uiStateFlowMovie.message,
                tryAgain = tryAgainCallBack
            )
            is SearchScreenUIState.Loaded -> {
                val moviesList = uiStateFlowMovie.movies
                LazyColumn(
                    modifier = modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(start = dp10),
                    verticalArrangement = Arrangement.spacedBy(dp20),
                ) {
                    items(
                        items = moviesList,
                        key = { model ->
                            model.id
                        }
                    ) { model ->
                        MovieSearchItem(
                            picture = model.poster.orEmpty(),
                            releaseDate = model.releaseDate,
                            language = model.language,
                            title = model.title,
                            onNavigateToInfo = onNavigateToInfo,
                            movieId = model.id
                        )
                    }
                    item { Spacer(modifier = modifier.width(dp2)) }
                }
            }
            SearchScreenUIState.Loading -> LoadingScreen()
            SearchScreenUIState.NoMovies -> Text(
                text = "no movies",
                fontSize = sp16,
                color = Color.White,
            )
        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    onGetSearchedMovies: (String) -> Unit,
    query: String
) {
    var showClearIcon by rememberSaveable { mutableStateOf(false) }

    if (query.isEmpty()) {
        showClearIcon = false
    } else if (query.isNotEmpty()) {
        showClearIcon = true
    }

    TextField(
        value = query,
        onValueChange = onGetSearchedMovies,
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                tint = Color.White,
                contentDescription = "Search"
            )
        },
        trailingIcon = {
            if (showClearIcon) {
                IconButton(onClick = { onGetSearchedMovies("") }) {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        tint = Color.White,
                        contentDescription = "Clear"
                    )
                }
            }
        },
        maxLines = 1,
        placeholder = { Text(text = stringResource(R.string.search)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = BlackBackgroundColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = RedButton,
            disabledPlaceholderColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = BlackBackgroundColor)
            .statusBarsPadding()
    )
}