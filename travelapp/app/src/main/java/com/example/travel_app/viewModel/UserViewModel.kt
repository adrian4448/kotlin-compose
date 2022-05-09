package com.example.travel_app.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*

class UserViewModel : ViewModel() {

    var userName by mutableStateOf("")

    var password by mutableStateOf("")

    var name by mutableStateOf("")

    var birthday by mutableStateOf("")

    var email by mutableStateOf("")


    fun registrar() {

        // api ou banco de dados ou regra de negócio
    }
}