package com.example.starwars.data

import androidx.lifecycle.MutableLiveData
import com.example.starwars.model.ListaPersonaggi
import retrofit2.Response

interface StarWarsDataSource {

    val person: ArrayList<ListaPersonaggi>
    val mutableLiveData: MutableLiveData<List<ListaPersonaggi>>

}