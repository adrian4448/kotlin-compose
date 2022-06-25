package com.example.travel_app.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travel_app.entity.TipoViagem
import com.example.travel_app.entity.Travel
import com.example.travel_app.repository.TravelRepository
import kotlinx.coroutines.launch

class TravelViewModel(
    private val repository: TravelRepository
): ViewModel()  {

    var id by mutableStateOf(0)

    var destiny by mutableStateOf("")

    var type by mutableStateOf(TipoViagem.LAZER)

    var comingDate by mutableStateOf("")

    var departureDate by mutableStateOf("")

    var budget by mutableStateOf(0.0)

    var user by mutableStateOf("")

    fun register() {
        val travel = Travel(destiny, type, comingDate, departureDate, user.toInt())
        viewModelScope.launch {
            repository.save(travel)
        }
    }
}