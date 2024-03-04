package com.example.movieapp.presentation.components.main_screen_components.home_screen_components

import android.annotation.SuppressLint
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.presentation.models.movies_list.MovieResultUIModel
import com.example.movieapp.presentation.theme.dp24
import com.example.movieapp.presentation.theme.dp25
import com.example.movieapp.presentation.theme.sp30
import com.example.movieapp.presentation.theme.sp5
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.immutableListOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

private const val SCROLL_ANIMATION_DURATION = 9000L

@SuppressLint("RestrictedApi", "UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PopularMoviesPager(
    list: ImmutableList<MovieResultUIModel>,
    onNavigateToInfo:(Int)->Unit,
    modifier: Modifier = Modifier
) {
    val popularMoviesList = list.take(7).toList()
    val pageCount = Int.MAX_VALUE
    val realSize = popularMoviesList.size
    val middlePage = pageCount / 2
    val pagerState = rememberPagerState(
        initialPage = middlePage - (middlePage % realSize),
        pageCount = { Int.MAX_VALUE })
    val isDraggedState = pagerState.interactionSource.collectIsDraggedAsState()
    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 400.dp, max = 610.dp),
        contentAlignment = Alignment.Center
    ) {
        HorizontalPager(
            beyondBoundsPageCount = 2,
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
        ) {
            val page = it % realSize
            PagerItem(
                uiModel = popularMoviesList[page],
                page = it,
                pagerState = pagerState,
                onNavigateToInfo = onNavigateToInfo
            )
        }
        Row(
            Modifier
                .height(dp24)
                .fillMaxWidth(0.9f)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Start
        ) {
            repeat(popularMoviesList.size) { iteration ->
                val currentPageFromPager = pagerState.currentPage % popularMoviesList.size
                val lineWeight = animateFloatAsState(
                    targetValue = if (currentPageFromPager == iteration) {
                        1.5f
                    } else if (iteration == currentPageFromPager - 1 || iteration == currentPageFromPager + 1) {
                        1f
                    } else if (iteration == currentPageFromPager - 2 || iteration == currentPageFromPager + 2) {
                        0.7f
                    } else {
                        0.5f
                    },
                    label = "weight",
                    animationSpec = tween(300, easing = EaseInOut)
                )
                val color =
                    if (currentPageFromPager == iteration) Color.White
                    else if (iteration == currentPageFromPager - 1 || iteration == currentPageFromPager + 1) {
                        Color.White.copy(alpha = 0.5f)
                    } else if (iteration == currentPageFromPager - 2 || iteration == currentPageFromPager + 2) {
                        Color.White.copy(alpha = 0.3f)
                    } else Color.White.copy(alpha = 0.1f)
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(color)
                        .weight(lineWeight.value)
                        .height(4.dp)
                )
            }
        }
        Text(
            text = stringResource(R.string.app_title),
            fontSize = sp30,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = dp25),
            letterSpacing = sp5
        )
        LaunchedEffect(isDraggedState) {
            snapshotFlow { isDraggedState.value }
                .collectLatest { isDragged ->
                    if (!isDragged) {
                        while (true) {
                            delay(SCROLL_ANIMATION_DURATION)
                            runCatching {
                                pagerState.animateScrollToPage(pagerState.currentPage.inc() % pagerState.pageCount)
                            }
                        }
                    }
                }
        }
    }

}


@Preview
@Composable
fun PopularMoviePagerPreview() {
    PopularMoviesPager(
        list = immutableListOf(MovieResultUIModel.unknown),
        onNavigateToInfo = {}
    )
}