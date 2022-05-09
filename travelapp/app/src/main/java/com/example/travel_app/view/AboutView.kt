package com.example.travel_app.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AboutView(navController: NavController) {
    Column() {
        Text(text = "About view")
    }
}