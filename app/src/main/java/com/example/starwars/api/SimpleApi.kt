package com.example.starwars.api

import com.example.starwars.model.StarWars
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("/api/people/1") // indicare l'indirizzo finale della get da fare
    //suspend fun getStar(): StarWars // indicare la classe dove salvare i dati (Person)
    //se si vuol fare un controllo se il get funzioni e non da errore ad esempio 404
    suspend fun getStar(): Response<StarWars>
}