package com.example.starwars.data

import androidx.lifecycle.MutableLiveData
import com.example.starwars.api.RetrofitInstance
import com.example.starwars.model.ListaPersonaggi
import retrofit2.Response


class StarWarsRepositoryImpl: StarWarsRepository {

    override val person: ArrayList<ListaPersonaggi> = ArrayList()
    override val mutableLiveData: MutableLiveData<List<ListaPersonaggi>> = MutableLiveData<List<ListaPersonaggi>>()

    override suspend fun getStar(): Response<ListaPersonaggi> {
        return RetrofitInstance.api.getStar()
    }

}