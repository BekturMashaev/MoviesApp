package com.example.movieapp.presentation.components.common.loading.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.presentation.theme.BlackBackgroundColor
import com.example.movieapp.presentation.theme.RedButton

@Composable
fun LoadingScreen() {

    Box(
        modifier = Modifier.fillMaxSize().background(BlackBackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = RedButton
        )
    }

}

@Preview
@Composable
fun LoadingScreenPreview() {
    MaterialTheme {
        LoadingScreen()
    }
}