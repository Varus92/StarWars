package com.example.starwars.data

import com.example.starwars.api.RetrofitInstance
import com.example.starwars.model.StarWars
import retrofit2.Response

class StarWarsRepositoryImpl: StarWarsRepository {

    override suspend fun getStar(): Response<StarWars> {
        return RetrofitInstance.api.getStar()
    }

}