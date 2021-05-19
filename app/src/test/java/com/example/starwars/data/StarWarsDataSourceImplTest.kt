package com.example.starwars.data

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class StarWarsDataSourceImplTest {


    private lateinit var starWars: StarWarsDataSourceImpl

    @Test
    fun getStarWarsMovies() {
        starWars.getStarWarsMovies().test().assertNoErrors()


         // .assertValueCount(1)

    }

    @Before
    fun setup(){
        starWars = StarWarsDataSourceImpl()

    }

}