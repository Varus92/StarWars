package com.example.starwars.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.starwars.R
import com.example.starwars.databinding.FragmentDetailPageBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class fragment_detail_page : DialogFragment() {

    private val args: fragment_detail_pageArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding : FragmentDetailPageBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailPageBinding.inflate(inflater, container, false)


        return binding.root

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val url = args

        Log.d("fine", url.toString())


        val nome = args.nome
        val altezza = args.altezza
        val data = args.data
        val uu = args.url
        Log.d("Qui", uu)
        binding.nomeDetail.text = nome
        binding.altezzaDetail.text = altezza.toString()
        binding.dataDetail.text = data


        binding.buttonBack.setOnClickListener {
            findNavController().navigate(fragment_detail_pageDirections.actionFragmentDetailPageToListPageFragment())
        }

    }

}