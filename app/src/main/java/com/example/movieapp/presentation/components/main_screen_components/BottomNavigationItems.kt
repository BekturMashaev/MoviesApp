package com.example.movieapp.presentation.components.main_screen_components

import com.example.movieapp.R
import com.example.movieapp.presentation.screens.main_screen.screens.home_screen.HomeScreenDestination
import com.example.movieapp.presentation.screens.main_screen.screens.library_screen.LibraryScreenDestination
import com.example.movieapp.presentation.screens.main_screen.screens.search_screen.SearchScreenDestination
import com.example.movieapp.presentation.screens.main_screen.screens.settings_screen.SettingsScreensDestination

data class BottomNavigationItemModel(
    val title: String,
    val icon: Int
)

fun bottomNavigationList() = listOf(
    BottomNavigationItemModel(
        HomeScreenDestination.route,
        R.drawable.home_icon,
    ),
    BottomNavigationItemModel(
        SearchScreenDestination.route,
        R.drawable.search_icon,
    ),
    BottomNavigationItemModel(
        LibraryScreenDestination.route,
        R.drawable.library_icon,
    ),
    BottomNavigationItemModel(
        SettingsScreensDestination.route,
        R.drawable.settings_icon,
    )
)