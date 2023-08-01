package com.example.trivia.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.trivia.R

class IncorrectoFragment : Fragment() {

    private lateinit var botonNext: Button
    private val args: IncorrectoFragmentArgs by navArgs()
    private var turnoActual = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_incorrecto, container, false)
        turnoActual = args.turnoActual + 1
        botonNext = binding.findViewById(R.id.buttonNext)
        botonNext.setOnClickListener{
            val direction = IncorrectoFragmentDirections.actionIncorrectoFragmentToTrivia(turnoActual)
            findNavController().navigate(direction)
        }
        return binding
    }
}