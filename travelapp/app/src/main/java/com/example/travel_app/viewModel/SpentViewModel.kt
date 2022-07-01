package com.example.travel_app.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travel_app.entity.Spent
import com.example.travel_app.repository.SpentRepository
import kotlinx.coroutines.launch

class SpentViewModel(
    private val repository: SpentRepository
): ViewModel() {

    var id by mutableStateOf(0)

    var date by mutableStateOf("")

    var value by mutableStateOf(0.0)

    var description by mutableStateOf("")

    var local by mutableStateOf("")

    var travelId by mutableStateOf(0)

    fun register() {
        val spent = Spent(date, value, description, local, travelId)
        viewModelScope.launch {
            repository.save(spent)
        }
    }

    fun findAllSpents(onSuccess: (spents: List<Spent>) -> Unit) {
        viewModelScope.launch {
            val spents = repository.findAll()
            onSuccess(spents)
        }
    }
}