package com.example.movieapp.presentation.components.main_screen_components.home_screen_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.sp20

@Composable
fun MoviesCategoryTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = sp20,
        textAlign = TextAlign.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dp10)
    )
}

@Preview
@Composable
fun MoviesCategoryTitlePreview() {
    MaterialTheme {
        MoviesCategoryTitle(
            text = "Upcoming Movies"
        )
    }
}