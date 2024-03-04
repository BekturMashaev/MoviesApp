package com.example.movieapp.presentation.screens.main_screen.screens.details_screen

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.movieapp.presentation.navigation.Destination

object DetailsScreenDestination:Destination {
    override val route = "details_screen"
    const val movieId = "movieId"
    val routeWithArgs = "$route/{$movieId}"
    val arguments = listOf(navArgument(movieId) { type = NavType.IntType })
}