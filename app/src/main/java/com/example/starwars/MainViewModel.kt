package com.example.starwars

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwars.data.StarWarsRepository
import com.example.starwars.model.ListaPersonaggi
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: StarWarsRepository
) : ViewModel() {

    private var myResponse: MutableLiveData<ListaPersonaggi> = MutableLiveData()

    fun getStar() : LiveData<ListaPersonaggi> {
        val disposable = repository.getStar()
            .observeOn(AndroidSchedulers.mainThread())
                //Subscribes to a Single and provides callbacks to handle the item it emits or any error notification it issues.
            .subscribe(
                //vi sono sempre due valori dentro il subscribe, 1 valore Result che indica la corretta ricezione dei dati
                {
                    result -> myResponse.value = result
                },
                //error per indicare che si è verificato un certo errore nel acquisire i dati
                { error -> Log.d("errore!!!", error.message ?: "msg not available", error)}
            )

        Log.d("risposta", myResponse.value.toString())
        return myResponse
    }

}