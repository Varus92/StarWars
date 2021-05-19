package com.example.starwars.di

import com.example.starwars.data.StarWarsDataSource
import com.example.starwars.data.StarWarsDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//Annotates a class that contributes to the object graph.
@Module
//An annotation that declares which component(s) the annotated class should be included in when Hilt generates the components.
// This may only be used with classes annotated with @Module or @EntryPoint.
@InstallIn(SingletonComponent::class)
class StarWarsDataSourceModule {

    //verranno inseriti tutti i dataSource che dovranno passare informazioni
    @Provides
    fun providesStarWarsDataSource(): StarWarsDataSource{
        return StarWarsDataSourceImpl()
    }
}