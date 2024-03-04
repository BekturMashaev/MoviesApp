package com.example.movieapp.presentation.components.main_screen_components.home_screen_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movieapp.presentation.models.movies_list.MovieResultUIModel
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.dp2
import kotlinx.collections.immutable.ImmutableList

@Composable
fun MoviesListLazyRow(
    onNavigateToInfo: (Int) -> Unit,
    moviesList: ImmutableList<MovieResultUIModel>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.padding(top = dp10),
        horizontalArrangement = Arrangement.spacedBy(dp10),
    ) {
        item { Spacer(modifier = modifier.width(dp2)) }
        items(
            items = moviesList,
            key = { model ->
                model.id
            }
        ) { model ->
            MovieItem(
                onNavigateToInfo = onNavigateToInfo,
                picture = model.poster.orEmpty(),
                language = model.language,
                releaseDate = model.releaseDate,
                title = model.title,
                movieId = model.id
            )
        }
        item { Spacer(modifier = modifier.width(dp2)) }
    }
}