package com.example.starwars.data

import com.example.starwars.model.StarWars
import retrofit2.Response

interface StarWarsRepository {

    suspend fun getStar(): Response<StarWars>  //viene inserito il response per controllare
    //se la chiamata è effettuata in modo corretto
}