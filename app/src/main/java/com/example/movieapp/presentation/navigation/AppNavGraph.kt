package com.example.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.screens.main_screen.MainDestination
import com.example.movieapp.presentation.screens.main_screen.MainScreen
import com.example.movieapp.presentation.screens.splash_screen.SplashDestination
import com.example.movieapp.presentation.screens.splash_screen.SplashScreen

@Composable
fun AppNavGraph(
    onBackPressedCallback: () -> Unit,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SplashDestination.route,
    ) {
        composable(MainDestination.route) {
            MainScreen(
                onBackPressedCallback = onBackPressedCallback
            )
        }
        composable(SplashDestination.route) {
            SplashScreen(
                onNavigation = { navController.navigate(MainDestination.route) }
            )
        }
    }
}