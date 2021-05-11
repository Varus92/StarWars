package com.example.starwars.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val okHttpClient by lazy {  //HttpURLConnection e Apache HTTP Client ; per inviare e ricevere dati dal web.
        OkHttpClient //Ciascuno di questi client richiedeva la scrittura di molto codice boilerplate all'interno di AsyncTask o nei metodi del thread in background.
            .Builder()  // Inoltre, questi client hanno le proprie serie di limitazioni quando si tratta di annullare una richiesta HTTP o un pool di connessioni.
            .addInterceptor(HttpLoggingInterceptor()  //INTERCEPTOR serve per controllare se la chiamata REST va a buon fine o se vi sono errori andandoli ad intercettare
            .setLevel(HttpLoggingInterceptor.Level.BODY) )  // e scoprire l'errore commesso
            // nel Run: I/okhttp.OkHttpClient: {"name":"Luke Skywalker","height":"172","mass":"77","hair_color":"blond","skin_color":"fair",..........}
            .build()
    }


    private val retrofit by lazy {

        Retrofit.Builder() // inizializziamo Retrofit Builder
            .client(okHttpClient)   //INSERIAMO LA FUNZIONE client(con l'interceptor) per visualizzare gli eventuali errori
            .baseUrl("https://swapi.dev/api/")  //andando ad inserire L'URL da dove andare a prendere i dati, Inseriamo l URL creata nel file RETROFITINSTANCE
            .addConverterFactory(GsonConverterFactory.create())  // inseriamo la funzione che permette di convertire i dati JSON ricevuti nella chiamata e li converte in GSON
            .build() // crea l'istanza di retrofit
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }

}