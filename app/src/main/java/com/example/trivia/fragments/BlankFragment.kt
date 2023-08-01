package com.example.trivia.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.trivia.R

class BlankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflamos la vista que luego retornamos
        var binding = inflater.inflate(R.layout.fragment_blank, container, false)

        // // listener del boton
        val botonPlay: Button = binding.findViewById(R.id.buttonPlay)
        botonPlay.setOnClickListener{ view ->
            Navigation.findNavController(view).navigate(BlankFragmentDirections.actionBlankFragmentToTrivia(0))
        }

        return binding
    }
}