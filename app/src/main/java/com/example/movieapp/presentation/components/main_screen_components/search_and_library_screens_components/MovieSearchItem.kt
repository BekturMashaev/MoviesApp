package com.example.movieapp.presentation.components.main_screen_components.search_and_library_screens_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
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
import androidx.compose.ui.unit.em
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.dp50
import com.example.movieapp.presentation.theme.dp70
import com.example.movieapp.presentation.theme.dp90
import com.example.movieapp.presentation.theme.sp13
import com.example.movieapp.presentation.theme.sp14
import com.example.movieapp.presentation.theme.sp16
import com.example.movieapp.presentation.theme.sp18
import com.example.movieapp.presentation.utils.bounceClick

@Composable
fun MovieSearchItem(
    picture: String,
    releaseDate: String,
    language: String,
    title: String,
    onNavigateToInfo: (Int) -> Unit,
    movieId: Int,
    modifier: Modifier=Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    var isButtonEnabled by remember { mutableStateOf(true) }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(dp90)
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
    ){
        Row(
            modifier = modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start
        ) {
            Card(
                modifier = modifier
                    .fillMaxHeight()
                    .width(dp70)
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
            Spacer(modifier = modifier.width(dp10))
            Column {
                Text(
                    text =title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = sp16,
                    maxLines = 2,
                    lineHeight = 1.1.em,
                    overflow = TextOverflow.Ellipsis
                )
                Row {
                    Text(
                        text ="$releaseDate • ${language.uppercase()}" ,
                        color = Color.White,
                        fontSize = sp13
                    )
                }
            }
        }
    }
}