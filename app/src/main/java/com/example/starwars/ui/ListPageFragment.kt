package com.example.starwars.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwars.MainViewModel
import com.example.starwars.data.StarWarsRepositoryImpl
import com.example.starwars.databinding.FragmentListPageBinding
import com.example.starwars.model.StarWars
import com.example.starwars.util.Adapters
import com.example.starwars.util.StarWarsDataSource

class ListPageFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private var _binding : FragmentListPageBinding? = null
    private val binding get() = _binding!!

    private var adapter = Adapters(listOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycleviewFrag.layoutManager = LinearLayoutManager(context)
        binding.recycleviewFrag.adapter = adapter

        //setupRecycler()
    }

    fun setupRecycler(){
        val repository = StarWarsRepositoryImpl()
        val viewModelFactory = StarWarsDataSource(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getStar()
        viewModel.myResponse.observe(this, Observer { response ->

            if (response.isSuccessful) {
                adapter = Adapters(response.body()?.results ?: listOf())
                binding.recycleviewFrag.adapter = adapter
            } else {
                Log.d("Response", response.errorBody().toString())
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