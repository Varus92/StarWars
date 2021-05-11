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
import com.example.starwars.util.Adapters
import com.example.starwars.util.StarWarsDataSource

class ListPageFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private var _binding : FragmentListPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycler()
    }

    fun setupRecycler(){
        val repository = StarWarsRepositoryImpl()
        val viewModelFactory = StarWarsDataSource(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getStar()
        viewModel.myResponse.observe(this, Observer { response ->

            if (response.isSuccessful) {
               response.body()?.let { Log.d("Response", it.results[1].name) }

                //binding.recycleviewFrag.adapter = response.body()?.results?.let {Adapters(it) }

                binding.recycleviewFrag.apply {
                    // set a LinearLayoutManager to handle Android
                    // RecyclerView behavior
                    layoutManager = LinearLayoutManager(activity)
                    // set the custom adapter to the RecyclerView
                    adapter = response.body()?.let { Adapters(it.results) }
                }

              /*      // Lookup the recyclerview in activity layout
                val rvContacts = binding.recycleviewFrag as RecyclerView

                // Create adapter passing in the sample user data
                val adapter = response.body()?.let { Adapters(it.results) }
                // Attach the adapter to the recyclerview to populate items
                rvContacts.adapter = adapter
                // Set layout manager to position the items
                rvContacts.layoutManager = LinearLayoutManager(context)
                // That's all!*/


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