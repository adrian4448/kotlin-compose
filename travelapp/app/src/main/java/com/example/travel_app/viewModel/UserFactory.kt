package com.example.travel_app.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.travel_app.repository.UserRepository

class UserFactory(val app:Application): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = UserRepository(app)
        val model = UserViewModel(repository)
        return model as T
    }
}