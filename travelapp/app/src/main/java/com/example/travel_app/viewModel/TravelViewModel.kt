package com.example.travel_app.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.travel_app.viewModel.enum.TipoViagemEnum

class TravelViewModel: ViewModel()  {

    var id by mutableStateOf(0)

    var destiny by mutableStateOf("")

    var type by mutableStateOf(TipoViagemEnum.LAZER)

    var comingDate by mutableStateOf("")

    var departureDate by mutableStateOf("")

    var budget by mutableStateOf(0.0)

    var user by mutableStateOf("")
}