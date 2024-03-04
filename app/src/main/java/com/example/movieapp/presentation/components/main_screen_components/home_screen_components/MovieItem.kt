package com.example.movieapp.presentation.components.main_screen_components.home_screen_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants
import com.example.movieapp.presentation.theme.dp150
import com.example.movieapp.presentation.theme.dp250
import com.example.movieapp.presentation.theme.sp13
import com.example.movieapp.presentation.theme.sp9
import com.example.movieapp.presentation.utils.bounceClick


@Composable
fun MovieItem(
    picture: String,
    language: String,
    releaseDate: String,
    title: String,
    onNavigateToInfo: (Int) -> Unit,
    movieId: Int,
    modifier: Modifier = Modifier,
) {
    val titleDescription = "$language • $releaseDate"
    val interactionSource = remember { MutableInteractionSource() }
    var isButtonEnabled by remember { mutableStateOf(true) }
    Box(
        modifier = modifier
            .width(dp150)
            .height(dp250)
            .background(Color.Transparent)
            .bounceClick()
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                if (isButtonEnabled) {
                    onNavigateToInfo(movieId)
                    isButtonEnabled = false
                }
            },
    ) {
        Column(modifier = modifier.fillMaxSize()) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = Constants.POSTER_PATH_URL + picture).apply(
                                block = fun ImageRequest.Builder.() {
                                    placeholder(R.drawable.place_holder)
                                },
                            ).build()
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

            }
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = sp13,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = titleDescription,
                color = Color.White,
                fontSize = sp9
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MovieItemPreview() {
    MaterialTheme {
        MovieItem(
            picture = "",
            title = "Halo",
            language = "KO",
            releaseDate = "2023-01-26",
            onNavigateToInfo = {},
            movieId = 0,
            modifier = Modifier.background(Color.Black)
        )
    }
}