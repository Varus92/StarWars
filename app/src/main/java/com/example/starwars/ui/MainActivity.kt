package com.example.starwars.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.starwars.MainViewModel
import com.example.starwars.R
import com.example.starwars.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)   //Binding
        setContentView(binding.root)

        //non inserisco nulla dentro la classe della main activity ma inserisco il tutto dentro il file XML dove inserisco il riferimento al navigation
        //che imposto il fragment di partenza e le varie action che deve eseguire tra i vari fragment!

    }


}