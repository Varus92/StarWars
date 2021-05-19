package com.example.starwars.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.starwars.R
import com.example.starwars.databinding.FragmentHomeBinding


class FragmentHome : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initialize ImageView
        val imageView: ImageView = binding.imageView as ImageView

        Glide.with(context)
            .load("https://1000marche.net/wp-content/uploads/2020/03/Star-Wars-logo.png")
            //inseriamo dentro la funzione URL dell immagine che vogliamo visualizzare
            .into(imageView) // dentro ImageView presente dentro il file XML


        //creo il richiamo del bottone al fine di passare da un fragment ad un altro
        binding.button.setOnClickListener {

            //la funzione serve per trovare IL Nav Controller ed eseguire il navigate al fine di spostarsi nel fragment successivo
            //dentro il navigate inserisco un IDRes dove indicheremo l'action che servira per spostarsi da un frag di partenza a quello di destinazione
            findNavController().navigate(R.id.action_fragmentHome_to_listPageFragment)
        }

    }
   }
