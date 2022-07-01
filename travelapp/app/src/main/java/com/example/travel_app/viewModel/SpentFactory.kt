package com.example.travel_app.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.travel_app.repository.SpentRepository

class SpentFactory(val app: Application): ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = SpentRepository(app)
        val model = SpentViewModel(repository)
        return model as T
    }
}