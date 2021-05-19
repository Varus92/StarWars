package com.example.starwars.data

import androidx.lifecycle.MutableLiveData
import com.example.starwars.model.ListaPersonaggi
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Singleton


interface StarWarsRepository {

    //acquisisco i dati dal DataSource
    //Single ->  the Reactive Pattern for a single value response
    fun getStar(): Single<ListaPersonaggi>  //viene inserito il response per controllare
    //se la chiamata è effettuata in modo corretto
}