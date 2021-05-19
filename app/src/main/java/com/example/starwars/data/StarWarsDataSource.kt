package com.example.starwars.data

import com.example.starwars.model.ListaPersonaggi
import io.reactivex.Single
import retrofit2.Response

interface StarWarsDataSource {

    fun getStarWarsMovies() : Single<ListaPersonaggi>

}