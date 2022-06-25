package com.example.travel_app.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.travel_app.components.BottomMenu

@Composable
fun AboutView(navController: NavController) {


    Scaffold(
        topBar = {
            Column() {
                Text(text = "About view")
            }
        },
        bottomBar = {
            BottomMenu(navController = navController)
        }
    ) { }

}