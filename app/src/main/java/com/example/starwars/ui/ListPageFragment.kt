package com.example.starwars.ui

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwars.MainViewModel
import com.example.starwars.databinding.FragmentListPageBinding
import com.example.starwars.model.StarWars
import com.example.starwars.util.Adapters
import com.google.android.material.transition.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ListPageFragment @Inject constructor(): Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding : FragmentListPageBinding? = null
    private val binding get() = _binding!!

    //creo l'adapter iniziale di elementi null, cosi da crearmi il layout e non darmi errore poiche non riesce a crearmi la recycleview
    private var adapter = Adapters(listOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListPageBinding.inflate(inflater, container, false)
        sharedElementEnterTransition = MaterialContainerTransform()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycleviewFrag.layoutManager = LinearLayoutManager(context)
        binding.recycleviewFrag.adapter = adapter

        setupRecycler()



    }
    private fun setupRecycler(){
        viewModel.getStar().observe(viewLifecycleOwner) { response ->
            adapter = Adapters(response?.results ?: listOf())
            binding.recycleviewFrag.adapter = adapter


            response.results[1].let { Log.d("ciao", it.url) }
            //richiamo l interface e assegno una classe anonima ( e' una classe che non ha un nome) il quale richiamo l Adapter
            //e faccio l'override della funzione che abbiamo definito precedentemente dove impostiamo che quando vado a cliccare sul bottone
            //richiamiamo la funzione findNavController che ci permette di passare nel next fragment
            adapter.personListener = object : Adapters.OnClickPersonListener {
                override fun onClickPerson(personStarWars: StarWars) {

                    //se nel navigation noi impostiamo che quando passiamo da un frag a un frag possiamo passare un argument che ci servira nel next frag
                    //che puo essere di qualsiasi tipo si voglia.
                    // Possiamo inoltre utilizzare il Direction anziche il IDRes e inserire successivamente il valore da voler passare al frag successivo
                    findNavController()
                        .navigate(
                            ListPageFragmentDirections
                                .actionListPageFragmentToFragmentDetailPage(
                                    personStarWars.url,
                                    personStarWars.name,
                                    personStarWars.height,
                                    personStarWars.birth_year
                                )
                        )
                }


            }


            /*
            se non andiamo ad inserire il Response come valore di ritorno
            e controlliamo se i valori inseriti.
            Log.d("Response", response.name)
            Log.d("Response", response.height.toString())
            Log.d("Response", response.gender)
            Log.d("Response", response.eye_color)*/
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}