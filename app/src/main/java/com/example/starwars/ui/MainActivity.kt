package com.example.starwars.ui

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.starwars.MainViewModel
import com.example.starwars.R
import com.example.starwars.data.StarWarsRepositoryImpl
import com.example.starwars.databinding.ActivityMainBinding
import com.example.starwars.util.StarWarsDataSource


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)   //Binding
        setContentView(binding.root)

        //Initialize ImageView
        val imageView: ImageView = binding.imageView as ImageView

        Glide.with(this)
            .load("https://1000marche.net/wp-content/uploads/2020/03/Star-Wars-logo.png")  //inseriamo dentro la funzione URL dell immagine che vogliamo visualizzare
            .into(imageView) // dentro ImageView presente dentro il file XML


        val repository = StarWarsRepositoryImpl()
        val viewModelFactory = StarWarsDataSource(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
       viewModel.getStar()
        viewModel.myResponse.observe(this, Observer { response ->

            if (response.isSuccessful) {
                binding.button.setOnClickListener {
                   setContentView(R.layout.fragment_list_page)
                }
                response.body()?.let { Log.d("Response", it.name) }
                Log.d("Response", response.body()?.height.toString())
                Log.d("Response", response.body()?.gender.toString())
                Log.d("Response", response.body()?.eye_color.toString())

            } else {
                Log.d("Response", response.errorBody().toString())
                binding.textView.text = response.code().toString()

            }


            /*
            se non andiamo ad inserire il Response come valore di ritorno
            e controlliamo se i valori inseriti.
            Log.d("Response", response.name)
            Log.d("Response", response.height.toString())
            Log.d("Response", response.gender)
            Log.d("Response", response.eye_color)*/
        })


    }

}