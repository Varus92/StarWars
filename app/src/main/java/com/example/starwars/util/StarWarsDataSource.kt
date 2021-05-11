package com.example.starwars.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.starwars.MainViewModel
import com.example.starwars.data.StarWarsRepository


class StarWarsDataSource (
    private val repository: StarWarsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}

