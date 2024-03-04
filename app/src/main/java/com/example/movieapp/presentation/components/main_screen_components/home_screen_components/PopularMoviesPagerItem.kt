package com.example.movieapp.presentation.components.main_screen_components.home_screen_components

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.em
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.airbnb.lottie.utils.MiscUtils
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants
import com.example.movieapp.presentation.models.movies_list.MovieResultUIModel
import com.example.movieapp.presentation.theme.BlackBackgroundColor
import com.example.movieapp.presentation.theme.RedButton
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.dp140
import com.example.movieapp.presentation.theme.dp16
import com.example.movieapp.presentation.theme.dp20
import com.example.movieapp.presentation.theme.dp22
import com.example.movieapp.presentation.theme.dp30
import com.example.movieapp.presentation.theme.dp5
import com.example.movieapp.presentation.theme.dp75
import com.example.movieapp.presentation.theme.sp10
import com.example.movieapp.presentation.theme.sp15
import com.example.movieapp.presentation.theme.sp26
import kotlin.math.absoluteValue


@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RestrictedApi")
@Composable
fun PagerItem(
    pagerState: PagerState,
    uiModel: MovieResultUIModel,
    page: Int,
    onNavigateToInfo: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    var isButtonEnabled by remember { mutableStateOf(true) }
    val pageOffset =
        ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
    val titleDescription = "${uiModel.language} • ${uiModel.releaseDate}"
    val scale = MiscUtils.lerp(1f, 2f, pageOffset)
    Box(modifier = modifier.fillMaxSize()) {
        Card(
            modifier = Modifier.fillMaxSize(), shape = RoundedCornerShape(ZeroCornerSize)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = Constants.POSTER_PATH_URL + uiModel.poster).apply(
                            block = fun ImageRequest.Builder.() {
                                placeholder(R.drawable.place_holder)
                            },
                        ).build()
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        scaleX *= scale
                        scaleY *= scale
                    },
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            BlackBackgroundColor,
                            Color.Transparent,
                            BlackBackgroundColor
                        )
                    )
                ),
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = dp20)
                .padding(horizontal = dp20)
        ) {
            Text(
                text = uiModel.title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = sp26,
                textAlign = TextAlign.Center,
                maxLines = 2,
                lineHeight = 1.5.em,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = modifier.height(dp10))
            Text(
                text = titleDescription.uppercase(),
                color = Color.White,
                fontSize = sp10,
                modifier = modifier.padding(bottom = dp16)
            )
            Button(
                onClick = {
                    if (isButtonEnabled) {
                        onNavigateToInfo(uiModel.id)
                        isButtonEnabled = false
                    }
                },
                shape = RoundedCornerShape(dp30),
                colors = ButtonDefaults.buttonColors(
                    RedButton
                ),
                modifier = modifier
                    .height(dp75)
                    .width(dp140)
                    .padding(bottom = dp20),
            ) {
                Row(
                    modifier = modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = modifier.size(dp22)
                    )
                    Spacer(modifier = modifier.size(dp5))
                    Text(
                        text = stringResource(R.string.watch_txt),
                        fontWeight = FontWeight.Medium,
                        fontSize = sp15,
                        color = Color.White,
                    )
                }
            }
        }
    }
}