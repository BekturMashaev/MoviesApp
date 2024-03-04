package com.example.movieapp.presentation.screens.main_screen.screens.details_screen

import androidx.activity.addCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants
import com.example.movieapp.presentation.components.common.error_screen.ErrorScreen
import com.example.movieapp.presentation.components.common.loading.screen.LoadingScreen
import com.example.movieapp.presentation.models.movie_info.MovieInfoDataModelUI
import com.example.movieapp.presentation.theme.BlackBackgroundColor
import com.example.movieapp.presentation.theme.RedButton
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.dp15
import com.example.movieapp.presentation.theme.dp20
import com.example.movieapp.presentation.theme.dp200
import com.example.movieapp.presentation.theme.dp28
import com.example.movieapp.presentation.theme.dp30
import com.example.movieapp.presentation.theme.dp32
import com.example.movieapp.presentation.theme.dp40
import com.example.movieapp.presentation.theme.dp46
import com.example.movieapp.presentation.theme.dp5
import com.example.movieapp.presentation.theme.dp50
import com.example.movieapp.presentation.theme.sp10
import com.example.movieapp.presentation.theme.sp11
import com.example.movieapp.presentation.theme.sp12
import com.example.movieapp.presentation.theme.sp13
import com.example.movieapp.presentation.theme.sp14
import com.example.movieapp.presentation.theme.sp15
import com.example.movieapp.presentation.theme.sp24

@Composable
fun DetailsScreen(
    onGetMovieInfo: () -> Unit,
    onBackPressedCallback: () -> Unit,
    uiStateFlowMovie: DetailsScreenUIState,
    onSaveButtonCallBack: (MovieInfoDataModelUI) -> Unit,
) {
    val backStackDispatcher = LocalOnBackPressedDispatcherOwner.current
    backStackDispatcher?.onBackPressedDispatcher?.addCallback {
        onBackPressedCallback()
    }
    LaunchedEffect(
        key1 = true,
    ) {
        onGetMovieInfo()
    }
    when (uiStateFlowMovie) {
        is DetailsScreenUIState.Loading -> LoadingScreen()
        is DetailsScreenUIState.Loaded -> {
            LoadedDetailsScreen(
                uiStateFlowMovie.movie,
                onBackPressedCallback = onBackPressedCallback,
                onSaveButtonCallBack = {
                    onSaveButtonCallBack(uiStateFlowMovie.movie)
                }
            )
        }

        is DetailsScreenUIState.Error -> ErrorScreen(message = uiStateFlowMovie.message) {
            onGetMovieInfo()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DetailsScreenPreview() {
    MaterialTheme {
        DetailsScreen(
            onGetMovieInfo = {},
            uiStateFlowMovie = DetailsScreenUIState.Loaded(
                MovieInfoDataModelUI.unknown
            ),
            onBackPressedCallback = {},
            onSaveButtonCallBack = {}
        )
    }
}

@Composable
fun LoadedDetailsScreen(
    modelUI: MovieInfoDataModelUI,
    onBackPressedCallback: () -> Unit,
    onSaveButtonCallBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(BlackBackgroundColor),
        ) {
            Box(
                modifier = modifier.fillMaxSize()
            ) {
                BackgroundPosterPath(poster = modelUI.posterPath)
                Column(
                    modifier = modifier.padding(horizontal = dp15)
                ) {
                    Spacer(modifier = modifier.height(380.dp))
                    Text(
                        text = modelUI.title,
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontSize = sp24,
                        textAlign = TextAlign.Start,
                        maxLines = 2,
                        lineHeight = 1.2.em,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(
                        modifier = modifier.padding(top = dp10),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            colors = CardDefaults.cardColors(Color.Transparent),
                            shape = RoundedCornerShape(dp5),
                            modifier = modifier.width(dp30)
                        ) {
                            Text(
                                text = if (modelUI.adult) {
                                    "12+"
                                } else {
                                    "7+"
                                },
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontSize = sp12,
                                modifier = modifier
                                    .fillMaxSize()
                                    .background(color = Color.White.copy(alpha = 0.7f))
                            )
                        }
                        Icon(
                            painter = painterResource(id = R.drawable.dot),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Text(
                            text = modelUI.releaseDate,
                            color = Color.White,
                            fontSize = sp10,
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.dot),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Text(
                            text = minutesToHours(modelUI.runtime),
                            color = Color.White,
                            fontSize = sp10,
                        )
                    }
                    val countryName = modelUI.country[0].uppercase()
                    val genres = modelUI.genres.joinToString { it }
                    Spacer(modifier = modifier.height(dp5))
                    Text(
                        text = "$countryName • $genres",
                        fontSize = sp10,
                        color = Color.White
                    )
                    Row(
                        modifier = modifier
                            .fillMaxWidth(0.95f)
                            .padding(top = dp15),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(dp30),
                            colors = ButtonDefaults.buttonColors(
                                RedButton
                            ),
                            modifier = modifier
                                .height(dp50)
                                .width(dp200),
                        ) {
                            Text(
                                text = stringResource(R.string.nothing),
                                fontWeight = FontWeight.Medium,
                                fontSize = sp15,
                                color = Color.White,
                            )
                        }
                        Spacer(modifier = modifier.weight(1f))
                        IconButton(
                            onClick = { onSaveButtonCallBack },
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.FavoriteBorder,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = modifier
                                    .size(dp28)
                                    .align(Alignment.CenterVertically)
                            )
                        }
                        Spacer(modifier = modifier.weight(1f))
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.MoreVert,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = modifier
                                    .size(dp28)
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }
                }
            }
            Column(
                modifier = modifier
                    .padding(horizontal = dp15)
                    .padding(top = dp20)
            ) {
                Text(
                    text = "${modelUI.voteAverage}",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = sp14,
                    modifier = modifier.fillMaxWidth()
                )
                Text(
                    text = "IMBD",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = sp11,
                    modifier = modifier.fillMaxWidth()
                )
                Spacer(modifier = modifier.height(dp20))
                ExpandableText(
                    text = modelUI.overview,
                    fontSize = sp13,
                )
            }
        }
    }
    FloatingBackButton(
        onBackPressedCallback = onBackPressedCallback
    )
}


@Composable
fun minutesToHours(minutes: Int): String {
    return if (minutes > 60) {
        val hours = minutes / 60
        val remainingMinutes = minutes % 60
        "${hours}h ${remainingMinutes}min"
    } else {
        "${minutes}h"
    }
}

@Composable
fun BackgroundPosterPath(
    poster: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.heightIn(min = 300.dp, max = 530.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = Constants.POSTER_PATH_URL + poster).apply(
                        block = fun ImageRequest.Builder.() {
                            placeholder(R.drawable.place_holder)
                        },
                    ).build()
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            BlackBackgroundColor,
                            Color.Transparent,
                            BlackBackgroundColor,
                        )
                    )
                ),
        )
    }
}

@Composable
fun FloatingBackButton(
    onBackPressedCallback: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.padding(top = dp40, start = dp10)) {
        FloatingActionButton(
            onClick = { onBackPressedCallback() },
            modifier = modifier
                .size(dp46)
                .align(Alignment.TopStart),
            containerColor = BlackBackgroundColor,
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(dp28)
            )
        }
    }
}

@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    text: String,
    collapsedMaxLine: Int = 4,
    fontSize: TextUnit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val clickable by remember { mutableStateOf(false) }
    val lastCharIndex by remember { mutableIntStateOf(0) }

    Column() {
        Text(
            modifier = textModifier
                .fillMaxWidth()
                .animateContentSize(),
            text = buildAnnotatedString {
                if (clickable) {
                    if (isExpanded) {
                        append(text)
                    } else {
                        val adjustText = text.substring(startIndex = 0, endIndex = lastCharIndex)
                            .dropLastWhile { Character.isWhitespace(it) || it == '.' }
                        append(adjustText)
                    }
                } else {
                    append(text)
                }
            },
            maxLines = if (isExpanded) Int.MAX_VALUE else collapsedMaxLine,
            fontSize = fontSize,
            lineHeight = 1.2.em,
            fontWeight = FontWeight.Medium,
            color = Color.White,
        )
    }
    IconButton(
        modifier = modifier.fillMaxWidth(),
        onClick = { isExpanded = !isExpanded }
    ) {
        Icon(
            imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp
            else Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            tint = Color.White,
            modifier = modifier.size(dp32)
        )
    }
}