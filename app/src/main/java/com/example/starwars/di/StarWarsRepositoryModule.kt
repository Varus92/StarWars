package com.example.starwars.di

import com.example.starwars.data.StarWarsDataSource
import com.example.starwars.data.StarWarsRepository
import com.example.starwars.data.StarWarsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// identifica la classe come un modulo
@Module
@InstallIn(SingletonComponent::class)
class StarWarsRepositoryModule {

    //vengono inseriti tutti i dataSource che passano informazioni alla nostra repository
    @Provides
    fun providesStarWarsRepository(starWarsDataSource: StarWarsDataSource) : StarWarsRepository{
        return StarWarsRepositoryImpl(starWarsDataSource)
    }


}