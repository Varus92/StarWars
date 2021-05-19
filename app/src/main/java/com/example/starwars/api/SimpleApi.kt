package com.example.starwars.api

import com.example.starwars.model.ListaPersonaggi
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("/api/people") // indicare l'indirizzo finale della get da fare
    //suspend fun getStar(): StarWars // indicare la classe dove salvare i dati (Person)
    //se si vuol fare un controllo se il get funzioni e non da errore ad esempio 404
    fun getStar(): Single<ListaPersonaggi>
}