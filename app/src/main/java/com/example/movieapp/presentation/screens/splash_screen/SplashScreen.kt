package com.example.movieapp.presentation.screens.splash_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.R
import com.example.movieapp.presentation.components.LottieIcons
import com.example.movieapp.presentation.theme.BlackBackgroundColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val SPLASH_SCREEN_TIME_MILLIS = 2050L

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigation: () -> Unit,
) {

    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(
        key1 = true,
        block = {
            coroutineScope.launch {
                delay(SPLASH_SCREEN_TIME_MILLIS)
                onNavigation()
            }
        }
    )
    Box(
        modifier = modifier.fillMaxSize().background(BlackBackgroundColor),
        contentAlignment = Alignment.Center,
    ) {
        LottieIcons(lottie = R.raw.lottie_title)
    }

}

@Preview
@Composable
fun SplashScreenPreview() {
    MaterialTheme {
        SplashScreen() {}
    }
}