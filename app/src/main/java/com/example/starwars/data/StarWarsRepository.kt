package com.example.starwars.data

import androidx.lifecycle.MutableLiveData
import com.example.starwars.model.ListaPersonaggi
import retrofit2.Response


interface StarWarsRepository {

    val person: ArrayList<ListaPersonaggi>
    val mutableLiveData: MutableLiveData<List<ListaPersonaggi>>
    suspend fun getStar(): Response<ListaPersonaggi>  //viene inserito il response per controllare
    //se la chiamata è effettuata in modo corretto
}