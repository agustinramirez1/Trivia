package com.example.trivia.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.trivia.R

class CorrectoFragment : Fragment() {

    private lateinit var botonNext: Button
    private val args: CorrectoFragmentArgs by navArgs()
    private var turnoActual = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_correcto, container, false)
        // cambiar a button ejemplo de error
        turnoActual = args.turnoActual + 1
        botonNext = binding.findViewById(R.id.buttonNext)
        botonNext.setOnClickListener{
            val direction = CorrectoFragmentDirections.actionCorrectoFragmentToTrivia(turnoActual)
            findNavController().navigate(direction)
        }
        return binding
    }
}