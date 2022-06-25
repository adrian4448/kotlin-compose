package com.example.travel_app.view

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.travel_app.ScreenManager
import com.example.travel_app.components.BottomMenu

@Composable
fun HomeView(navController: NavHostController ) {
    Scaffold(
        bottomBar = {
            BottomMenu(navController = navController)
        }
    ) { }
}