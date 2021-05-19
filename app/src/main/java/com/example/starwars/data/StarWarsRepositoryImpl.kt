package com.example.starwars.data

import androidx.lifecycle.MutableLiveData
import com.example.starwars.api.RetrofitInstance
import com.example.starwars.model.ListaPersonaggi
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject


class StarWarsRepositoryImpl @Inject constructor(
    private val starWarsDatasource: StarWarsDataSource
) : StarWarsRepository {

    //richimo la funzione del dataSource e ritorno i dati acquisiti nel DataSource
    override fun getStar(): Single<ListaPersonaggi> {
        return starWarsDatasource.getStarWarsMovies()
    }

}