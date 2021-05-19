package com.example.starwars.data

import androidx.lifecycle.MutableLiveData
import com.example.starwars.api.RetrofitInstance
import com.example.starwars.api.SimpleApi
import com.example.starwars.model.ListaPersonaggi
import com.example.starwars.model.StarWars
import io.reactivex.Single
import retrofit2.Response

class StarWarsDataSourceImpl : StarWarsDataSource {


    //tramite questa funzione mi prendo i dati dalla chiamata Api, successivamente li passo al Repository
    override fun getStarWarsMovies(): Single<ListaPersonaggi> {
        return RetrofitInstance.api.getStar()
    }

}