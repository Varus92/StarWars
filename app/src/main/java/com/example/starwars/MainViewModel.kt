package com.example.starwars

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwars.data.StarWarsRepository
import com.example.starwars.model.StarWars
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel(private val repository: StarWarsRepository) : ViewModel() {

    var myResponse: MutableLiveData<Response<StarWars>> = MutableLiveData()

    fun getStar() {
        viewModelScope.launch {
            val response = repository.getStar()
            myResponse.value = response
        }
    }

}